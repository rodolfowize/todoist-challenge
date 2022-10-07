# todoist-challenge
This is an API test application for the validation of the Todoist Task and Project endpoints built with Jmeter. 
It is comprised of one single (testplan.jmx) test plan including 30 tests between positive and negative tests:

- Projects:
  * Get All projects
  * Get a project
  * Get a project: not found
  * Create a new project
  * Create a new project: missing mandatory request parameter
  * Create a new project: wrong parameter type
  * Update a project
  * Update a project: not found
  * Update a project: invalid project
  * Delete a project
  * Delete a project: invalid project

- Task:
  * Get active task
  * Get an active task
  * Get an active task: not found
  * Get an active task: invalid task
  * Create a new task
  * Create a new task: missing mandatory request parameter
  * Create a new task: wrong parameter type
  * Delete a task
  * Delete a task: invalid task
  * Update a task
  * Update a task: not found
  * Update a task: invalid task
  * Close a task
  * Close a task: not found
  * Close a task: invalid task
  * Reopen a task
  * Reopen a task: not found
 * Reopen a task: invalid task
 * Wrong bearer token

In order to execute this test suite, you require to have Jmeter setup locally in the machine or server where you plan to run it from.
