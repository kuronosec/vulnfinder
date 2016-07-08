var navBarUI;

// Create the navBar ui iframe and inject it in the current page
function initNavBar() {
  var iframe = document.createElement("iframe");
  iframe.setAttribute("src", chrome.runtime.getURL("resources/nav-bar.html"));
  iframe.setAttribute("style", "position: fixed; top: 0; left: 0; z-index: 10000; overflow-y: auto; height: 100%; width:15%");
  document.body.appendChild(iframe);

  return navBarUI = {
    iframe: iframe, visible: true
  };
}

function toggleNavBar(navBarUI) {
  if (navBarUI.visible) {
    navBarUI.visible = false;
    navBarUI.iframe.style["display"] = "none";
  } else {
    navBarUI.visible = true;
    navBarUI.iframe.style["display"] = "block";
  }
}

// Handle messages from the add-on background page (only in top level iframes)
if (window.parent == window) {
  chrome.runtime.onMessage.addListener(function(msg) {
    if (msg == "toggle-in-page-navBar") {
      if (navBarUI) {
        toggleNavBar(navBarUI);
      } else {
        navBarUI = initNavBar();
      }
    }
  });
}
