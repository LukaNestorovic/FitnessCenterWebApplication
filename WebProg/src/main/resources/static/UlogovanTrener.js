$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let trenerId = urlParams.get('trenerId');
    $('#dodaj').attr('href', 'Treninzi.html?trenerId=' + trenerId);
});