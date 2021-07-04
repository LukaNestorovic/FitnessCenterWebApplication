$(document).on("submit", "#dodajSaluForm", function (event) {
    event.preventDefault();
    let kapacitet = $("#kapacitet").val();
    let oznaka = $("#oznaka").val();
    let newSala = {
        kapacitet,
        oznaka
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/sale/za-fitnes",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newSala),
        success: function (res) {
            alert("Sala " + res.id + " je uspešno kreiran!");
            window.location.href = "FitnesCentri.html";
        },
        error: function () {
            alert("Greška prilikom dodavanja trenera!");
        }
    });
});