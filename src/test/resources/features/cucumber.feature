#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: verify  post,get, update in the API

  Scenario: User will be able to Save Programs and batches with the given URL
    #@GetAllPrograms
    Given user get all programs with base url
    When User make a GET request to get all programs with base url
    Then User get response with all the programs and get status code 200
    #@GetAllbatches
    Given user get all batches with base url
    When User make a GET request to get all batches with base url
    Then User get response with all the batches and get status code 200
    #create 1 st program
    Given user create 1st program with base url
    When user make a post request with end point "saveprogram"
    Then user should get response body and status code should be 201
    #create 2nd program
    Given user create 2nd program with base url and request body
    When user make a post request for 2nd program with end point "saveprogram"
    Then user get response body 201
    #getprogrambyProgramId
    When user make a get request with an end point "/programs/programId"
    Then user should get status code as "200" and responsebody
    #@updateprogramByProgName
    When User make a PUT request to update program by using programName(Modify 1st program)
    Then User should get status code as "200" and updated response body
    #@updateById
    When User make a PUT request to update program by using programId(Modify 2nd program)
    Then User get status code as "200" and updated response body
    #@create_1st_Batch
    Given User create 1st batch with base Url
    When User make a POST request  for batch with end point "batches"
    Then User  get response body and status code should be 201
    #@create_2nd_Batch
    Given User create 2nd batch with base Url
    When User make a POST request  for  2nd batch with end point "batches"
    Then User get response body for 2nd batch and status code should be 201
    #@getBatchById
    When User make GET request with an end point "/batches/batchId/(BatchId)"
    Then User gets status code as "200" and response body
    #@updateBatchBybatchId
    When User make a PUT request to update program with end point "batches/(batchId)"
    Then User should get status code as "200" for batch and response body
    #@DeleteBatchById
    When User make a DELETE request with an end point "/batches/(BatchId)"
    Then User gets status code "200" batch will be deleted
