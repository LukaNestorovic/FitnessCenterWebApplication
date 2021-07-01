$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/treninzi",
        dataType: "json",
        success: function (res) {

            for (i = 0; i < res.length; i++) {
                let row = "<tr>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "<th>" + res[i].opis + "</th>";
                row += "<th>" + res[i].tip_treninga + "</th>";
                row += "<th>" + res[i].trajanje + "</th>";
                let btn = "<button class='btnTermin' data-id=" + res[i].id + ">Termini</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#treninzi').append(row);
            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});

$(document).on('click', '.btnTermin', function () {
    let treningId = this.dataset.id;
    window.location.href = "Termin.html?treningId=" + treningId;
});
