$(document).on("submit", "#logInForm", function (event) {
    event.preventDefault();

    let korisnicko_ime = $("#korisnicko_ime").val();
    let lozinka = $("#lozinka").val();
    let uloga = $("#uloga :selected").val();

    if(uloga === "Trener") {

        let newTrener = {
            korisnicko_ime,
            lozinka,
            uloga
        }

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/login",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newTrener),
            success: function (res) {
                alert("AAAAA");
            },
            error: function () {
                alert("Error");
            }
        });
    } else if (uloga === "Clan") {

        let newClan = {
            korisnicko_ime,
            lozinka,
            uloga
        }

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/login",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newClan),
            success: function (res) {
                alert("BBBBB");
            },
            error: function () {
                alert("Error");
            }
        });
    }
});