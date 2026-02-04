# Technical Assignment: QA Engineer

## Application Under Test

**Sauce Demo** - https://www.saucedemo.com

A sample e-commerce web application with:
- User authentication
- Product catalog
- Shopping cart
- Checkout flow

**Test Credentials** (available on login page):
- `standard_user` / `secret_sauce`
- Other users with different behaviors (locked, problem, etc.)

---

## Deliverables

### Part 1: Exploratory Testing & Bug Reports (25 points)

Spend 30-45 minutes exploring the application and document your findings.

**Create `submission/BUG_REPORTS.md` with:**

1. **5 Bug Reports** - Find and document 5 bugs/issues in the application

   Each bug report must include:
   - Clear title
   - Steps to reproduce
   - Expected vs actual behavior
   - Severity (Critical/High/Medium/Low)
   - Screenshot description (describe what you would capture)

2. **Testing Notes** - Brief summary of:
   - Areas you tested
   - Your testing approach
   - Any areas you'd prioritize for deeper testing

---

### Part 2: Test Cases (25 points)

**Create `submission/TEST_CASES.md` with:**

Write **15 test cases** covering the core user journeys:

| Area | Test Cases Required |
|------|---------------------|
| Login | 4 test cases |
| Product/Cart | 5 test cases |
| Checkout | 4 test cases |
| General/Edge Cases | 2 test cases |

Each test case must include:
- Test ID
- Title
- Pre-conditions
- Steps
- Expected result
- Priority (P1/P2/P3)

---

### Part 3: Test Automation (35 points)

**Create working automated tests in `submission/automation/`**

Implement automated tests for Sauce Demo using your preferred framework (Playwright, Cypress, or Selenium).

**Requirements:**
- **5 E2E test cases** covering:
  - Login (valid + invalid)
  - Add product to cart
  - Complete checkout flow
  - At least one negative test

**Your submission must include:**
- Working test code
- `package.json` with dependencies
- `README.md` with:
  - Setup instructions
  - How to run tests
  - Framework choice justification (2-3 sentences)

**Evaluation criteria:**
- Tests actually run and pass
- Code quality and organization
- Proper use of selectors and waits
- Clear test structure

---

### Part 4: QA Process Proposal (15 points)

**Create `submission/QA_PROCESS.md` with:**

As QA hire, propose lightweight processes for the team:

1. **Bug Severity Definitions** (4 levels with examples)

2. **Release Checklist** - What should be verified before each release? (8-10 items)

3. **Testing Strategy** - Brief paragraph on how you'd approach testing for a startup:
   - What types of testing would you prioritize?
   - How would you balance speed vs coverage?

---

## Submission Structure

```
submission/
├── BUG_REPORTS.md      # Part 1
├── TEST_CASES.md       # Part 2
├── QA_PROCESS.md       # Part 4
└── automation/         # Part 3
    ├── tests/
    │   └── (your test files)
    ├── package.json
    └── README.md
```

---

## Scoring Summary

| Part | Points | Focus |
|------|--------|-------|
| Bug Reports | 25 | Finding issues, documentation quality |
| Test Cases | 25 | Coverage, clarity, structure |
| Automation | 35 | Working code, quality, best practices |
| QA Process | 15 | Practical, startup-appropriate processes |
| **Total** | **100** | |

---

## Tips

- **Quality over quantity** - Well-documented bugs are better than many poorly written ones
- **Working code matters** - We will run your automation tests
- **Be practical** - Propose processes that work for a small team, not enterprise overhead
- **Show your thinking** - Brief explanations of your choices are valuable

---

Good luck!
