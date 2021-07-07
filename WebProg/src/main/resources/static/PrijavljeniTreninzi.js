$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let treningId = urlParams.get('treningId');
    let urlParams1 = new URLSearchParams(window.location.search);
    let terminId = urlParams1.get('terminId');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/treninzi/" + treningId,
        dataType: "json",
        success: function (res) {
            $('#naziv').text(res.naziv);
            $('#opis').text(res.opis);
            $('#tip_treninga').text(res.tip_treninga);
            $('#trajanje').text(res.trajanje);
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/" + terminId,
        dataType: "json",
        success: function (res) {
            $('#cena').text(res.cena);
            $('#datum_vreme').text(res.datum_vreme);

        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});