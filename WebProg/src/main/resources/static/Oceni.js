$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let treningId = urlParams.get('treningId');
    let urlParams1 = new URLSearchParams(window.location.search);
    let clanId = urlParams1.get('clanId');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/odradjeni-treninzi/" + treningId,
        dataType: "json",
        success: function (res) {
            $('#ocena').val(res.ocena);
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });

    $(document).on("submit", "#dodajTerminForm", function (event) {
        event.preventDefault();
        let ocena = $("#ocena").val();

        let newOdradjeni = {
            ocena
        }

        $.ajax({
            type: "PUT",
            url: "http://localhost:8080/api/odradjeni-treninzi/" + treningId,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newOdradjeni),
            success: function (res) {
                alert("Odradjeni trening " + res.id + " je uspešno ocenjen!");
                window.location.href = "OdradjeniTreninzi.html?clanId=" + clanId;
            },
            error: function () {
                alert("Greška prilikom ocenjivanja odradjenog treninga!");
            }
        });
    });
});