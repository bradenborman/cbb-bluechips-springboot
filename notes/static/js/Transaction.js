function addSearchTag() {
  var tagValue = $("#tagInput")
    .val()
    .trim()
    .toUpperCase();
  if (tagValue == "" || tagValue == null) return;

  var count = 1;
  const urlParams = new URLSearchParams(window.location.search);

  for (let p of urlParams) {
    count++;
  }

  urlParams.append("param" + count, tagValue);
  window.location.replace("/transactions?" + urlParams);
}

function removeTag(paramsToDrop) {
  const searchParams = new URLSearchParams(window.location.search);
  searchParams.delete(paramsToDrop);
  window.location.replace("/transactions?" + searchParams);
}
