$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let clanId = urlParams.get('clanId');
    $('#dodaj1').attr('href', 'TreningZaClanove.html?clanId=' + clanId);
    $('#dodaj2').attr('href', 'PrijavljeniTreninzi.html?clanId=' + clanId);
    $('#dodaj3').attr('href', 'SviOdradjeniTreninzi.html?clanId=' + clanId);
    $('#dodaj4').attr('href', 'OdradjeniTreninziBezOcene.html?clanId=' + clanId);
    $('#dodaj5').attr('href', 'OdradjeniTreninzi.html?clanId=' + clanId);
    $('#dodaj6').attr('href', 'PregledProfila.html?clanId=' + clanId);
});