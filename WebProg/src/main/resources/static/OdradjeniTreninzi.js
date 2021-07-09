$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let clanId = urlParams.get('clanId');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/odradjeni-treninzi/za-clana/" + clanId,
        dataType: "json",
        success: function (res) {

            for (i = 0; i < res.length; i++) {
                let row = "<tr>";
                row += "<td>" + res[i].ocena + "</td>";
                row += "<th>" + res[i].naziv + "</th>";
                row += "<th>" + res[i].tip_treninga + "</th>";
                row += "<th>" + res[i].datum_vreme + "</th>";
                row += "</tr>";

                $('#sviodradjenitreninzi').append(row);

                if(res[i].ocena != null) {
                    let row = "<tr>";
                    row += "<td>" + res[i].ocena + "</td>";
                    row += "<th>" + res[i].naziv + "</th>";
                    row += "<th>" + res[i].tip_treninga + "</th>";
                    row += "<th>" + res[i].datum_vreme + "</th>";
                    row += "</tr>";

                    $('#odradjenitreninzi').append(row);
                }
                else{
                    let row = "<tr>";
                    row += "<td>" + res[i].ocena + "</td>";
                    row += "<th>" + res[i].naziv + "</th>";
                    row += "<th>" + res[i].tip_treninga + "</th>";
                    row += "<th>" + res[i].datum_vreme + "</th>";
                    let btn = "<button class='btnOceni' data-id=" + res[i].id + ">Oceni</button>";
                    row += "<td>" + btn + "</td>";
                    row += "</tr>";

                    $('#odradjenitreninzibezocene').append(row);
                }
            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});

$(document).on('click', '.btnOceni', function () {
    let treningId = this.dataset.id;
    let urlParams = new URLSearchParams(window.location.search);
    let clanId = urlParams.get('clanId');
    window.location.href = "Oceni.html?treningId=" + treningId + "&clanId=" + clanId;
});