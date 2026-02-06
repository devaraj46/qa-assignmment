# Test Cases

| Test Case ID | TC_LOGIN_001 |
|-------------|--------------|
| Title | User logs in with valid credentials |
| Pre-conditions | User account exists |
| Steps | 1. Navigate to Login page (https://www.saucedemo.com/) <br> 2. Enter valid credentials <br> 3. Click on the Login button |
| Expected Result | User is logged in and navigated to product catalog page |
| Priority | P1 |

---

| Test Case ID | TC_LOGIN_002 |
|-------------|--------------|
| Title | Login fails with invalid password |
| Pre-conditions | User account exists |
| Steps | 1. Enter valid username and invalid password (standard_user / 123456789) <br> 2. Click on the Login button |
| Expected Result | Error message should be displayed and login should be blocked |
| Priority | P1 |

---

| Test Case ID | TC_LOGIN_003 |
|-------------|--------------|
| Title | Login validation for empty credentials |
| Pre-conditions | - |
| Steps | 1. Leave username and password fields empty <br> 2. Click on the Login button |
| Expected Result | Error messages should be displayed |
| Priority | P2 |

---

| Test Case ID | TC_LOGIN_004 |
|-------------|--------------|
| Title | Password field masks input characters |
| Pre-conditions | - |
| Steps | 1. Enter password in password field |
| Expected Result | Password characters are masked |
| Priority | P3 |

---

| Test Case ID | TC_LOGIN_005 |
|-------------|--------------|
| Title | Verify login behavior for username case sensitivity |
| Pre-conditions | User account exists with username `standard_user` |
| Steps | 1. Navigate to Login page <br> 2. Enter username in different case <br> 3. Enter correct password <br> 4. Click Login |
| Expected Result | Login succeeds if case-insensitive, otherwise error message displayed |
| Priority | P2 |

---

## Product / Cart

| Test Case ID | TC_CART_001 |
|-------------|-------------|
| Title | User can view product catalog |
| Pre-conditions | User is logged in |
| Steps | Navigate to product catalog page |
| Expected Result | Products are displayed correctly |
| Priority | P1 |

---

| Test Case ID | TC_CART_002 |
|-------------|-------------|
| Title | User adds product to cart |
| Pre-conditions | User is logged in |
| Steps | 1. Select product <br> 2. Click Add to Cart |
| Expected Result | Product added and cart count updated |
| Priority | P1 |

---

| Test Case ID | TC_CART_003 |
|-------------|-------------|
| Title | Cart displays correct product details |
| Pre-conditions | Product added to cart |
| Steps | Navigate to cart page |
| Expected Result | Correct name, image, and price displayed |
| Priority | P1 |

---

| Test Case ID | TC_CART_004 |
|-------------|-------------|
| Title | User removes product from cart |
| Pre-conditions | Product added to cart |
| Steps | 1. Navigate to cart <br> 2. Click Remove |
| Expected Result | Product removed and UI updated |
| Priority | P1 |

---

| Test Case ID | TC_CART_005 |
|-------------|-------------|
| Title | Cart persists after browser refresh |
| Pre-conditions | Product added to cart |
| Steps | Refresh browser |
| Expected Result | Cart items remain intact |
| Priority | P2 |

---

| Test Case ID | TC_CART_006 |
|-------------|-------------|
| Title | Cart persists after logout and re-login |
| Pre-conditions | User logged in with items in cart |
| Steps | 1. Add product <br> 2. Logout <br> 3. Login again <br> 4. Open cart |
| Expected Result | Cart items retained |
| Priority | P1 |

---

| Test Case ID | TC_CART_007 |
|-------------|-------------|
| Title | Sorting does not affect cart UI |
| Pre-conditions | Product added to cart |
| Steps | 1. Add product <br> 2. Apply sorting |
| Expected Result | Cart UI unaffected |
| Priority | P1 |

---

| Test Case ID | TC_CART_008 |
|-------------|-------------|
| Title | Cart total calculation is correct |
| Pre-conditions | Multiple products available |
| Steps | 1. Add multiple products <br> 2. View cart |
| Expected Result | Total equals sum of prices |
| Priority | P1 |

---

| Test Case ID | TC_CART_009 |
|-------------|-------------|
| Title | Add from grid and remove from detail page |
| Pre-conditions | User logged in |
| Steps | 1. Add product from grid <br> 2. Open detail page <br> 3. Click Remove |
| Expected Result | Product removed and cart updated |
| Priority | P1 |

---

## Checkout

| Test Case ID | TC_CHECKOUT_001 |
|-------------|-----------------|
| Title | User can proceed to checkout |
| Pre-conditions | Product in cart |
| Steps | Navigate to cart and click Checkout |
| Expected Result | User redirected to user details page |
| Priority | P1 |

---

| Test Case ID | TC_CHECKOUT_002 |
|-------------|-----------------|
| Title | Checkout with valid user details |
| Pre-conditions | Logged in with non-empty cart |
| Steps | Enter valid details and continue |
| Expected Result | User proceeds to next step |
| Priority | P1 |

---

| Test Case ID | TC_CHECKOUT_003 |
|-------------|-----------------|
| Title | Mandatory field validation |
| Pre-conditions | On checkout user details page |
| Steps | Leave required fields empty and continue |
| Expected Result | Validation errors displayed |
| Priority | P1 |

---

| Test Case ID | TC_CHECKOUT_004 |
|-------------|-----------------|
| Title | Order placed successfully |
| Pre-conditions | Valid checkout details |
| Steps | Complete checkout |
| Expected Result | Order confirmation displayed |
| Priority | P1 |

---

| Test Case ID | TC_CHECKOUT_005 |
|-------------|-----------------|
| Title | Checkout blocked for empty cart |
| Pre-conditions | Logged in with empty cart |
| Steps | Navigate to cart and click Checkout |
| Expected Result | Checkout blocked and message displayed |
| Priority | P1 |

---

## General / Edge Cases

| Test Case ID | TC_GEN_001 |
|-------------|------------|
| Title | Page refresh handled gracefully |
| Pre-conditions | User logged in |
| Steps | Refresh page |
| Expected Result | No data loss |
| Priority | P2 |

---

| Test Case ID | TC_GEN_002 |
|-------------|------------|
| Title | Session expires after inactivity |
| Pre-conditions | User logged in |
| Steps | Stay inactive and perform action |
| Expected Result | Redirected to login page |
| Priority | P2 |
