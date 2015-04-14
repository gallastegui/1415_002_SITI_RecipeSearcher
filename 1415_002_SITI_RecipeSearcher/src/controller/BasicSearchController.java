package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import test.SearcherTest;
import view.BasicSearchView;
import view.SimpleSearchView;

import java.util.*;

import model.connector.SqlConnection;
import model.entity.Recipe;
import model.filtering.*;
import model.index.ScoredRecipe;
import model.index.indexing.LuceneIndexer;
import model.index.searching.LuceneSearcher;

public class BasicSearchController implements IController, ActionListener
{
	private String sql;
	private SqlConnection sqlConn;
	private LuceneIndexer indexer;
	private LuceneSearcher searcher;
	private BasicSearchView view;
	String comboboxText;
	private String descriptionText;
	private SearcherTest jframe;
	private ArrayList<Recipe> recipeResults;

	public BasicSearchController()
	{
		sqlConn = new SqlConnection("resources\\allrecipesv1.db");
	}
	
	public void setJframe(SearcherTest jframe)
	{
		this.jframe = jframe;
	}
	
	public void addDescriptionText(String descriptionText)
	{
		this.descriptionText = descriptionText;
	}
	
	public ArrayList<Recipe> applyFilteredSearch()
	{
		//sql = sqlConn.buildBasicSearchQuery(this.incIngredients, this.remIngredients,this.descriptionText);
		
		return sqlConn.executeSearch(sql);
	}
	
	public BasicSearchView getView()
	{
		return view;
	}

	public void setView(BasicSearchView view)
	{
		this.view = view;
	}
	
	public ArrayList<Recipe> getRecipeResults()
	{
		return recipeResults;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		 String actionCommand = ((JButton) e.getSource()).getActionCommand();
		 
		 if(actionCommand.equals("back"))
		 {
			 this.jframe.setFlag(4);
		 }
		 else if(actionCommand.equals("Search"))
		 {
			 this.descriptionText = this.view.getTextField().getText();
			 Object[] allSelectedAsArray = this.view.getComboBox().getSelectedObjects();
			 
			 for(Object o : allSelectedAsArray)
			 {
				 comboboxText = (String) o;
			 }
			 fillRecipes("SQLITE");
			 this.jframe.setFlag(5);
			//System.out.println(sqlConn.buildBasicSearchQuery(incIngredients, remIngredients, descriptionText));
			//recipeResults = sqlConn.executeSearch(sqlConn.buildBasicSearchQuery(incIngredients, remIngredients, descriptionText));
			//this.jframe.setFlag(1);
		 }
	}
	
	public void fillRecipes(String mode)
	{
		String query = "";
		
		if(!mode.isEmpty())
		{
			if(mode.equals("SQLITE"))
			{
				if(sqlConn == null)
					sqlConn = new SqlConnection("resources\\allrecipesv1.db");
				query = sqlConn.buildBasicSearchQuery(descriptionText, comboboxText);
				recipeResults = sqlConn.executeSearch(query);
			}
			else if(mode.equals("LUCENE"))
			{
				ArrayList<ScoredRecipe> scoredRecipes = new ArrayList<ScoredRecipe>();
				
				if(indexer == null)
				{
					indexer = new LuceneIndexer();
					indexer.load("resources\\index");
				}
				if(searcher == null)
				{
					searcher = new LuceneSearcher();
					if(searcher.getSearcher() == null)
					{
						searcher.build(indexer);
					}
				}
				scoredRecipes = (ArrayList<ScoredRecipe>) searcher.search(descriptionText);
				if(!scoredRecipes.isEmpty())
				{
					
					query = query + "SELECT * FROM RECIPE WHERE recipeId = "+ scoredRecipes.get(0).getRecipeAsoc().getRecipeId();
					for(ScoredRecipe aux : scoredRecipes)
					{
						query = query + "OR recipeId = "+aux.getRecipeAsoc().getRecipeId();
					}
					recipeResults = sqlConn.executeSearch(query);
				}
			}
		}
	}
}
