package com.example.gluecode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import com.example.page.CandidatePage;
import com.example.page.LogIn;
import com.example.page.ViewAllJobsPage;
import com.example.page.WelcomePage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApplyForJobTests {
	public WelcomePage wp;
	public LogIn lp;
	public WelcomePage wp2;
	public LogIn lp2;
	public CandidatePage cp;
	public ViewAllJobsPage vajp;
	

	@Given("a user is at the welcome page of BurntOut")
	public void a_user_is_at_the_welcome_page_of_burnt_out() throws InterruptedException {
	    TimeUnit.SECONDS.sleep(1);
	    this.wp = new WelcomePage(BurntOutDriverUtility.driver);
	    assertEquals(this.wp.header.getText(), "Welcome to BurntOut!");
	}
	
	@When("a user inputs clicks the Sign in button")
	public void a_user_inputs_clicks_the_sign_in_button() {
		this.wp.signInButton.click();
	}
	@Then("the user is redirected to the login page")
	public void the_user_is_redirected_to_the_login_page() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		this.lp = new LogIn(BurntOutDriverUtility.driver);
		assertEquals(this.lp.header.getText(), "Welcome to BurntOut!");
	}
	@When("the user is at the Log in page")
	public void the_user_is_at_the_log_in_page() {
		assertEquals(this.lp.header.getText(), "Welcome to BurntOut!");
	}
	@When("the user enters their {string} and {string}")
	public void the_user_enters_their_and(String string, String string2) {
	    this.lp.logIn(string, string2);
	}
	
	@Then("the user is redirected to the welcome screen")
	public void the_user_is_redirected_to_the_welcome_screen() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		this.cp = new CandidatePage(BurntOutDriverUtility.driver);
	    assertEquals(this.cp.title.getText(), "Welcome to BurntOut!");
	}
	
	@When("the candidate clicks the View Jobs link\"")
	public void the_candidate_clicks_the_view_jobs_link() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		this.cp.clickViewJobsLink();
	}
	
	@Then("the candidate is redirected to the View Jobs page")
	public void the_candidate_is_redirected_to_the_view_jobs_page() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		this.vajp = new ViewAllJobsPage (BurntOutDriverUtility.driver);
		TimeUnit.SECONDS.sleep(2);
		assertEquals(this.vajp.title.getText(), "Search for a job");
	}
}