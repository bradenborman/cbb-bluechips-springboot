//importScripts('/cache-polyfill.js');

//Attempting to cache bootstrap files for quicker loading

//self.addEventListener('install', function(e) {
// e.waitUntil(
//   caches.open('airhorner').then(function(cache) {
//     return cache.addAll([
//       '/',
//       '/index.html',
//       '/index.html?homescreen=1',
//       '/?homescreen=1',
//       '/styles/main.css',
//       '/scripts/main.min.js',
//       '/sounds/airhorn.mp3'
//     ]);
//   })
// );
//});


butInstall.addEventListener('click', () => {
  console.log('👍', 'butInstall-clicked');
  const promptEvent = window.deferredPrompt;
  if (!promptEvent) {
    // The deferred prompt isn't available.
    return;
  }
  // Show the install prompt.
  promptEvent.prompt();
  // Log the result
  promptEvent.userChoice.then((result) => {
    console.log('👍', 'userChoice', result);
    // Reset the deferred prompt variable, since
    // prompt() can only be called once.
    window.deferredPrompt = null;
    // Hide the install button.
    divInstall.classList.toggle('hidden', true);
  });
});

window.addEventListener('appinstalled', (event) => {
  console.log('👍', 'appinstalled', event);
});