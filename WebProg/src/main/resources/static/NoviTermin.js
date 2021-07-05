$(document).on("submit", "#dodajTerminForm", function (event) {
    event.preventDefault();
    let urlParams = new URLSearchParams(window.location.search);
    let treningId = urlParams.get('treningId');
    let cena = $("#cena").val();
    let datum_vreme = $("#datum_vreme").val();
    let newTermin = {
        cena,
        datum_vreme
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/sale/za-trening/" + treningId,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newTermin),
        success: function (res) {
            alert("Termin " + res.id + " je uspešno kreiran!");
            window.location.href = "Termin.html";
        },
        error: function () {
            alert("Greška prilikom dodavanja termina!");
        }
    });
});