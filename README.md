
---

# FinFlow Tester - Data Flow Coverage for FinanceMate

**FinFlow Tester** is a comprehensive testing framework for the **FinanceMate** application, a Java-based terminal tool offering a suite of financial calculators. The project ensures thorough validation using **Data Flow Graphs (DFGs)** and **Data Flow Coverage Criteria** to test all possible definition-use (DU) paths of variables.

## Features of FinanceMate

FinanceMate provides the following financial calculators:
- Employee Provident Fund (EPF)
- Public Provident Fund (PPF)
- Systematic Investment Plan (SIP)
- Systematic Withdrawal Plan (SWP)
- Taxation Calculations
- Lumpsum Investment Returns
- Gratuity Calculations
- Retirement Corpus Calculator
- Goal Savings Calculator
- Budget Planning Calculator

## Testing Methodology

The testing methodology employs **Data Flow Graphs (DFGs)** and **JUnit** to achieve:
- **All-Defs Coverage**: Ensures every variable definition is tested at least once.
- **All-DU-Paths Coverage**: Guarantees comprehensive testing of all possible flows from definitions to their respective uses, including complex paths and loops.

### Tools Used
1. **Data Flow Graph Coverage Web Application**: Automates the generation of DFGs and validates test paths.
2. **JUnit Framework**: Facilitates automated testing and result analysis.

## Key Components of the Project
- **Testing Code and Test Cases**: Covers each financial calculator in FinanceMate.
- **Rigorous Coverage Metrics**: All definitions and uses of variables are exercised.
- **Automation for Efficiency**: Integration with JUnit enables streamlined execution and monitoring.

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/VrajNaik/Software-Testing-MiniProject.git
   ```
2. Navigate to the project directory and build the project:
   ```bash
   cd Software-Testing-MiniProject
   mvn clean install
   ```
3. Execute the test suite:
   ```bash
   mvn test
   ```

## Authors
- **Vraj Jatin Naik**  
  Roll No.: MT2023050  
  Email: [Vraj.Naik@iiitb.ac.in](mailto:Vraj.Naik@iiitb.ac.in)


- **Arjun Gangani**  
  Roll No.: MT2023153  
  Email: [Arjun.Gangani@iiitb.ac.in](mailto:Arjun.Gangani@iiitb.ac.in)

## Guided By
- **Prof. Meenakshi D Souza**  
  International Institute of Information Technology, Bangalore

## GitHub Repository
Explore the complete project at [GitHub](https://github.com/VrajNaik/Software-Testing-MiniProject).

---