package com.bookstore.step_defs;

import com.bookstore.services.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookStore_StepDefs {

    GetAllBooks getAllBooks= new GetAllBooks();
    AddNewUser addNewUser= new AddNewUser();
    GenerateToken generateToken= new GenerateToken();
    AuthorizeUser authorizeUser= new AuthorizeUser();
    AddNewBookToUser addNewBookToUser= new AddNewBookToUser();
    UpdateBook updateBook= new UpdateBook();
    DeleteBook deleteBook= new DeleteBook();


    @When("Get All Books")
    public void get_All_Books() {
        getAllBooks.getAllBooks();
    }

    @Then("Validate that all books are listed")
    public void validate_that_all_books_are_listed() {
     getAllBooks.validateThatAllBooksAreListed();
    }



    @When("Add new user")
    public void add_new_user() {
     addNewUser.addNewUser();
    }

    @Then("Validate that the new user is posted")
    public void validate_that_the_new_user_is_posted() {
     addNewUser.validateThatUserPosted();
    }


    @When("Generate Token")
    public void generate_Token() {
     generateToken.generateToken();
    }

    @Then("Validate that the new user is generated")
    public void validate_that_the_new_user_is_generated() {
     generateToken.validateTokenIsGenerated();
    }


    @When("Authorize User")
    public void authorize_User() {
      authorizeUser.authorizeUser();
    }


    @Then("Validate that the user is authorized")
    public void validate_that_the_user_is_authorized() {
      authorizeUser.validateThatUserIsAuthorized();
    }


    @When("Assign a new book to the user")
    public void assign_a_new_book_to_the_user() {
     addNewBookToUser.assignNewBook();
    }


    @Then("Validate that the book is assigned to the user")
    public void validate_that_the_book_is_assigned_to_the_user() {
     addNewBookToUser.validateThatBookIsAssigned();
    }


    @When("Update an existing book")
    public void update_an_existing_book() {
      updateBook.updateAnExistingBook();
    }



    @Then("Validate that the book is updated")
    public void validate_that_the_book_is_updated() {
      updateBook.validateThatBookIsUpdated();
    }


    @When("Delete an existing book")
    public void delete_an_existing_book() {
      deleteBook.deleteAndExistingBook();
    }



    @Then("Validate that the book is removed")
    public void validate_that_the_book_is_removed() {
   deleteBook.validateBookIsRemoved();
    }




}
