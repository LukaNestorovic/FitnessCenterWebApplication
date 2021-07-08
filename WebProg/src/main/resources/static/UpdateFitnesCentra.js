$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let fitnesId = urlParams.get('fitnesId');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/fitnescentri/" + fitnesId,
        dataType: "json",
        success: function (res) {
            $('#naziv').text(res.naziv);
            $('#adresa').text(res.adresa);
            $('#email').text(res.email);
            $('#broj_telefona').text(res.broj_telefona);
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });

    $(document).on("submit", "#dodajFitnesCentarForm", function (event) {
        event.preventDefault();
        let naziv = $("#naziv").val();
        let adresa = $("#adresa").val();
        let email = $("#email").val();
        let broj_telefona = $("#broj_telefona").val();

        let newFitnesCentar = {
            naziv,
            adresa,
            email,
            broj_telefona
        }

        $.ajax({
            type: "PUT",
            url: "http://localhost:8080/api/fitnescentri",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newFitnesCentar),
            success: function (res) {
                alert("Fitnes centar " + res.id + " je uspešno ispravljen!");
                window.location.href = "FitnesCentri.html";
            },
            error: function () {
                alert("Greška prilikom ispravke fitnes centra!");
            }
        });
    });
});