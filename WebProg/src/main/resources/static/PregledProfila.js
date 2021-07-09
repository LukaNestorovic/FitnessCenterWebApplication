$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let clanId = urlParams.get('clanId');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/registracijaclana/" + clanId,
        dataType: "json",
        success: function (res) {
            $('#korisnicko_ime').val(res.korisnicko_ime);
            $('#lozinka').val(res.lozinka);
            $('#ime').val(res.ime);
            $('#prezime').val(res.prezime);
            $('#kontakt_telefon').val(res.kontakt_telefon);
            $('#email').val(res.email);
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });

    $(document).on("submit", "#dodajTerminForm", function (event) {
        event.preventDefault();
        let korisnicko_ime = $("#korisnicko_ime").val();
        let lozinka = $("#lozinka").val();
        let ime = $("#ime").val();
        let prezime = $("#prezime").val();
        let kontakt_telefon = $("#kontakt_telefon").val();
        let email = $("#email").val();

        let newTermin = {
            korisnicko_ime,
            lozinka,
            ime,
            prezime,
            kontakt_telefon,
            email
        }

        $.ajax({
            type: "PUT",
            url: "http://localhost:8080/api/registracijaclana/" + clanId,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newTermin),
            success: function (res) {
                alert("Profil je uspešno ispravljen!");
                window.location.href = "UlogovanClan.html?clanId=" + clanId;
            },
            error: function () {
                alert("Greška prilikom ispravke profila!");
            }
        });
    });
});