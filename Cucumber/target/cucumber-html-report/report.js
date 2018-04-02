$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("featurefile/productCategory/ProductVerification.feature");
formatter.feature({
  "line": 2,
  "name": "ProductCategoryPage",
  "description": "",
  "id": "productcategorypage",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@tag"
    }
  ]
});
formatter.before({
  "duration": 3767699924,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Verify Products based on price filters",
  "description": "",
  "id": "productcategorypage;verify-products-based-on-price-filters",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "navigate to application page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user click on dress navigation menu",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "click on sort by price lowest first filter \"Price: Lowest first\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "verify product is filtered according to price",
  "keyword": "Then "
});
formatter.match({
  "location": "ProductCategory.navigate_to_application()"
});
formatter.result({
  "duration": 19208959820,
  "status": "passed"
});
formatter.match({
  "location": "ProductCategory.user_click_on_dress_navigation_menu()"
});
formatter.result({
  "duration": 7741286094,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Price: Lowest first",
      "offset": 44
    }
  ],
  "location": "ProductCategory.click_on_sort_by_price_lowest_first_filter(String)"
});
formatter.result({
  "duration": 361355074,
  "status": "passed"
});
formatter.match({
  "location": "ProductCategory.verify_product_is_filtered_according_to_price()"
});
formatter.result({
  "duration": 206028850,
  "status": "passed"
});
formatter.after({
  "duration": 754116780,
  "status": "passed"
});
});