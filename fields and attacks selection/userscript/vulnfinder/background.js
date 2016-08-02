var activeNavBar = false;

// Send a message to the current tab's content script.
function toggleToolbar() {
  chrome.tabs.query({ active: true, currentWindow: true }, function(tabs) {
    chrome.tabs.sendMessage(tabs[0].id, "toggle-in-page-navBar");
      (!activeNavBar)? true:false;
  });
}

// if (activeNavBar) {
//     toggleToolbar();
// }

// Handle the browser action button.
chrome.browserAction.onClicked.addListener(toggleToolbar);

// Handle connections received from the add-on toolbar ui iframes.
// chrome.runtime.onConnect.addListener(function (port) {
//   if (port.sender.url == chrome.runtime.getURL("resources/nav-bar.html")) {
//     // Handle port messages received from the connected toolbar ui frames.
//     port.onMessage.addListener(toggleToolbar);
//   }
// });

/*
 Called when the item has been created, or when creation failed due to an error.
 We'll just log success/failure here.
 */
function onCreated(n) {
    if (chrome.runtime.lastError) {
        console.log("error creating item:" + chrome.runtime.lastError);
    } else {
        console.log("item created successfully");
    }
}

/*
 Called when the item has been removed, or when there was an error.
 We'll just log success or failure here.
 */
function onRemoved() {
    if (chrome.runtime.lastError) {
        console.log("error removing item:" + chrome.runtime.lastError);
    } else {
        console.log("item removed successfully");
    }
}

/*
 Create all the context menu items.
 */
chrome.contextMenus.create({
    id: "sql-injection",
    type: "checkbox",
    title: chrome.i18n.getMessage("contextMenuItemSQLInjection"),
    contexts: ["editable"]
}, onCreated);

chrome.contextMenus.create({
    id: "authentication",
    type: "checkbox",
    title: chrome.i18n.getMessage("contextMenuItemAuthentication"),
    contexts: ["editable"]
}, onCreated);

chrome.contextMenus.create({
    id: "xss",
    type: "checkbox",
    title: chrome.i18n.getMessage("contextMenuItemXSS"),
    contexts: ["editable"]
}, onCreated);

chrome.contextMenus.create({
    id: "authorization",
    type: "checkbox",
    title: chrome.i18n.getMessage("contextMenuItemAuthorization"),
    contexts: ["all"],
}, onCreated);

chrome.contextMenus.create({
    id: "privilege-scalation",
    type: "checkbox",
    title: chrome.i18n.getMessage("contextMenuItemPrivilegeScalation"),
    contexts: ["all"],
}, onCreated);

/*
 Toggle checkedState, and update the menu item's title
 appropriately.

 Note that we should not have to maintain checkedState independently like
 this, but have to because Firefox does not currently pass the "checked"
 property into the event listener.
 */
function updateCheckUncheck() {
    checkedState = !checkedState;
    if (checkedState) {
        chrome.contextMenus.update("check-uncheck", {
            title: chrome.i18n.getMessage("contextMenuItemUncheckMe"),
        });
    } else {
        chrome.contextMenus.update("check-uncheck", {
            title: chrome.i18n.getMessage("contextMenuItemCheckMe"),
        });
    }
}

/*
 The click event listener, where we perform the appropriate action given the
 ID of the menu item that was clicked.
 */
chrome.contextMenus.onClicked.addListener(function(info, tab) {
  switch (info.menuItemId) {
    case "sql-injection":
      console.log(info.selectionText);
      break;
    case "authentication":
      chrome.contextMenus.remove(info.menuItemId, onRemoved);
      break;
    case "xss":
      borderify(tab.id, blue);
      break;
    case "authorization":
      borderify(tab.id, green);
      break;
    case "privilege-scalation":
      updateCheckUncheck();
      break;
  }
});
