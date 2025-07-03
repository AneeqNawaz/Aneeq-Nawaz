# 🧪 Monefy Android App – Exploratory Testing Session

**Tester**: Aneeq  
**Date**: July 07, 2025  
**Platform Tested**: Android  
**App Version**: 1.22.2 
**Test Duration**: ~2 hours  
**Device Used**: Samsung S22 Ultra-S908ZKAXAA (Android 15 One UI 7.0)

---

## 🔎 Testing Charters

| Charter # | Title | Description |
|-----------|-------|-------------|
| C1 | Welcome Screen - Onboarding | Explore adding transactions from the home screen, assess UI flow, check all Buttons,Texts and data persistence |
| C2 | Add Expense/Income | Perform CRUD transactions from the home and relevant pages(Income/Expense), assess UI flow, field validation, and data persistence |
| C3 | Search Functionality | Explore search by giving input and with voice command 🎙️ |
| C4 | Permission Handling | Explore app behavior when granting or denying permissions (notifications, storage) |
| C5 | Widget and Shortcuts | Test adding Monefy's home screen widget and quick entry functionality |
| C6 | Other core locked feautre | Not able to test |

---

## ✅ Findings & Observations

### C1: Add Expense/Income
- ✔️ Overall UI is smooth and balanced on all slide
- ❌ On Purchase slide there is a restor button on click no purchase found thrown, there should be an option to login or remove restore
- ❌ Claim offer directly poped out payment screen, there should be login first before buying

### C2: Add Expense/Income
- ✔️ Transaction entry is smooth, need to handle large inputs although it's an expense management app but good to have if covert amount in millions
- ❌ UI/UX is not friendly, should be red color for expense and green for income, same option button icon the left and right of balance button, swipe up close setting 
- ✔️ Balance updates immediately

### C3: Search Functionality
- ✔️ Search is function/responsive and easy to use, bring relevant data. voice command also functional

### C4: Permission Handling
- ✔️ Not able to test much, but looks good

### C5: Widget and Shortcuts
- ✔️ Widget displays balance correctly, direct action were working
- ❌ Widget appearance glitches, and flaky maybe due to unpaid version

---

## 📊 Charter Prioritization

| Priority | Charter | Reason |
|----------|---------|--------|
| Low 🧩 | C1 | Info should be attractive and correct, so user stay on app |
| High 🔥 | C2 | Core feature — defects here impact all users |
| Medium ✍️ | C3 | Affects usability but not critical flow |
| Low ⚙️ | C4 | Permission flow is standard and non-blocking |
| Low 🧩 | C5 | Widget is helpful, but secondary |


---

## ⚠️ Risk Analysis
<pre>
| Risk Type            | Description                                                | Mitigation                                               |
|----------------------|------------------------------------------------------------|-----------------------------------------------------------
| Data Integrity       | Failed backups could result in loss of financial records   | Validate and confirm backups; retry mechanism            |
| Currency Mismatch    | Incorrect currency symbols or formats can mislead users    | Improve localization testing; stricter format validation |
| Widget Inconsistency | Inaccurate display or dark mode issues hurt trust          | Add automated visual tests for widgets                   |
| Permission Failures  | Users may get stuck if access is denied and not re-prompted| Guide users to settings or allow retry via UI            |
</pre>
---

## ✅ Summary

The Monefy Android app provides a smooth experience overall, but suffers from some medium-risk issues and UI polish. Prioritizing fixes around transaction validation and sync would significantly boost user trust and app reliability.
