$(document).on("submit", "#logInForm", function (event) {
    event.preventDefault();

    let korisnicko_ime = $("#korisnicko_ime").val();
    let lozinka = $("#lozinka").val();
    let uloga = $("#uloga").val();

    if(uloga === "Trener") {

        let newTrener = {
            korisnicko_ime,
            lozinka,
            uloga
        }

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/logintrenera",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newTrener),
            success: function (res) {
                alert("Uspesno ste se ulogovali kao trener");
                let trenerId = res.id;
                window.location.href = "UlogovanTrener.html?trenerId=" + trenerId;
            },
            error: function () {
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
            url: "http://localhost:8080/api/loginclana",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newClan),
            success: function (res) {
                alert("Uspesno ste se ulogovali kao clan");
                let clanId = res.id;
                window.location.href = "UlogovanClan.html?clanId=" + clanId;
            },
            error: function () {
            }
        });
    } else if (uloga === "Administrator") {
        let newAdministrator = {
            korisnicko_ime,
            lozinka,
            uloga
        }

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/loginadministratora",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newAdministrator),
            success: function (res) {
                alert("Uspesno ste se ulogovali kao administrator");
                let administratorId = res.id;
                window.location.href = "UlogovanAdministrator.html?administratorId=" + administratorId;
            },
            error: function () {
            }
        });
    }
});