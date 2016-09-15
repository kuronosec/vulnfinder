var activeNavBar = false;
var TOEDomain = null;

// Send a message to the current tab's content script.
function toggleToolbar() {
    chrome.tabs.query({active: true, currentWindow: true}, function (tabs) {
        if (!activeNavBar) {
            activeNavBar = true;
            chrome.browserAction.setIcon({path: "icons/32.png"});
        } else {
            activeNavBar = false;
            chrome.browserAction.setIcon({path: "icons/disable/32.png"});
        }
        chrome.tabs.sendMessage(tabs[0].id, {action:"toggle-in-page-navBar", currentTOE: TOEDomain});
    });
}

function handleTabs(activeInfo) {
    chrome.tabs.query({active: true, currentWindow: true}, function (tabs) {
        if (activeNavBar) {
            chrome.tabs.sendMessage(tabs[0].id, {action:"add-in-page-navBar", currentTOE: TOEDomain});
        } else {
            chrome.tabs.sendMessage(tabs[0].id, {action:"remove-in-page-navBar", currentTOE: TOEDomain});

        }
    });
}

//Handle the change of tabs
chrome.tabs.onActivated.addListener(handleTabs);

//Handle the creation of tabs
chrome.tabs.onUpdated.addListener(handleTabs);

// Handle the browser action button.
chrome.browserAction.onClicked.addListener(toggleToolbar);


function handleMessage(message, sender) {
    console.log("message from the content script: " +
        message.TOEDomain);
    console.log("sender " + sender);
    TOEDomain = message.TOEDomain;

}

chrome.runtime.onMessage.addListener(handleMessage);

