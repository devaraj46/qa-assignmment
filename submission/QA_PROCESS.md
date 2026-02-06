# Bug Severity Definition

Bug severity refers to how serious the impact of a bug is on the application, system, or end user.

There are **four levels of bug severity**:

## 1. Critical
A bug that blocks core functionality, causes data loss, security issues, or makes the application unusable, with **no workaround** available.

**Example:**  
User is not able to add items to the cart.

## 2. High
A major feature is broken or behaves incorrectly, significantly impacting users, but a **workaround exists**.

**Example:**  
User is not able to remove a product from the cart through the product grid view, but can remove it from the product details page or checkout page.

## 3. Medium
Functionality works but behaves incorrectly in specific scenarios or edge cases.

**Example:**  
User is not able to click the *Remove* button for the last product item in the grid view.

## 4. Low
Minor issues with no functional impact. Mostly cosmetic or usability-related.

**Example:**  
Button alignment issues, incorrect mouse pointers, inconsistent text size or alignment.

---

# Release Checklist

- All smoke test cases (happy/positive flows) are successful
- No open **Critical** or **High** severity bugs
- Release scope reviewed and confirmed
- Regression testing completed for impacted features
- Logs and alerts configured before release
- Rollback plan and feature flags in place
- Third-party service health checks completed
- No critical errors in browser console
- Cross-browser sanity testing completed
- Data integrity verification completed

---

# Testing Strategy

In a startup environment, the primary goal is to avoid slowing down development while ensuring that no blocking or high-impact issues reach production and negatively affect customers or product credibility.

To achieve this, an **iterative testing approach** is followed with a focus on fast feedback:

- Priority is given to **happy flow testing** for core functionalities
- **Exploratory testing** is used to uncover real-world issues and edge cases quickly
- **Smoke and basic regression testing** ensure stability of critical features
- **API and integration testing** are emphasized for backend-heavy or high-risk changes
- Collaboration with the team is essential to enable **feature flags** and **rollback mechanisms**

To balance speed and coverage:
- Deep testing is focused on areas with the highest business and user impact
- Low-risk features are tested lightly to avoid over-testing
- **Automation is introduced gradually** for critical, repetitive, and stable scenarios

This approach ensures release confidence while maintaining development velocity.
