$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let treningId = urlParams.get('treningId');

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/za-trening/" + treningId,
        dataType: "json",
        success: function (res) {
            for (i = 0; i < res.length; i++) {
                let row = "<tr>";
                row += "<td>" + res[i].cena + "</td>";
                row += "<th>" + res[i].datum_vreme + "</th>";
                let btn = "<button class='btnPrijavi' data-id=" + res[i].id + ">Prijavi</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#termini').append(row);
            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});

$(document).on('click', '.btnPrijavi', function () {
    let terminId = this.dataset.id;
    let urlParams = new URLSearchParams(window.location.search);
    let clanId = urlParams.get('clanId');
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/prijavljeni-treninzi/za-clana/" + clanId + "/termin/" + terminId,
        dataType: "json",
        contentType: "application/json",
        success: function (res) {
            alert("Termin " + res.id + " je uspešno prijavljen!");
            window.location.href = "PrijavljeniTreninzi.html?clanId=" + clanId + "&terminId=" + terminId;
        },
        error: function () {
            alert("Greška prilikom prijave treninga!");
        }
    });
});