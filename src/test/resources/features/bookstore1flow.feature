@wip
Feature: BookStore Flow

  Scenario: Flow Test
    When Get All Books
    Then Validate that all books are listed
    When Add new user
    Then Validate that the new user is posted
    When Generate Token
    Then Validate that the new user is generated
    When Authorize User
    Then Validate that the user is authorized
    When Assign a new book to the user
    Then Validate that the book is assigned to the user
    When Update an existing book
    Then Validate that the book is updated
    When Delete an existing book
    Then Validate that the book is removed