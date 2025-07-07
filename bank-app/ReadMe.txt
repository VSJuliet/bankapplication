--- Bank APP Services

A user has an account at MarlowBank and should be able to control their account through an ATM. The end goal of this project is
to:
1. Allow users to deposit and withdraw money from an ATM (Keep in mind withdrawal limitations - no overdraft allowed)
2. Allow simultaneous access of an account (joint accounts), so it's important to check the order of withdrawals (balance should
never fall below 0)

## Prerequisites

- Java 17
- STS or any other IDE
- Postgresql database (software installed and used through pgAdmin)
   create a database as bankapp, and set the password as "password" for the user postgres 
- Maven 
- Github 
- Postman

Execution of the project

1. Clone the project from Git repository and import as maven project in Git to STS or IDE
2. Do a maven clean build
3. Run the project as SpringBoot App
4. Database will be initialized and tables will be created
5. The following APIs can be validated using postman

	1. Get All Accounts 
		GET: http://localhost:8080/api/bank/getAll
	2. Get Account by Account Number
		GET: http://localhost:8080/api/bank/get/account/{accNum}
	3. Add Bank Account
		POST: http://localhost:8080/api/bank/add
		Body: {
    			"accNumber" : "1009003030",
    			"accHolderName" : "Sophia",
    			"accType" : "Savings",
    			"accBalance" : "3000.00"
			}
	4. Deposit ammount to account
		PUT: http://localhost:8080/api/bank/deposit
			{
    				"accNumber" : "1009003030",
    				"accBalance" : "12000.00"
			}
	5. Withdraw ammount from account
		PUT: http://localhost:8080/api/bank/withdraw
			{
    				"accNumber" : "1009003030",
    				"accBalance" : "10000.00"
			}
	6. Delete account by account number
		DELETE: http://localhost:8080/api/bank/delete/{accNum}

## Database
	Table: bank_accounts - Holds Bank account details
	Table: atm_transactions - Transaction history is captured here for deposits and withdrawal.

References
- Attaching the postman collection
- Swagger URL: http://localhost:8080/swagger-ui/index.html
- Logging is enabled using log4j2


