$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let clanId = urlParams.get('clanId');
    let urlParams1 = new URLSearchParams(window.location.search);
    let terminId = urlParams1.get('terminId');

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/prijavljeni-treninzi/za-clana/" + clanId,
        dataType: "json",
        success: function (res) {
            for (i = 0; i < res.length; i++) {
                let row = "<tr>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "<th>" + res[i].tip_treninga + "</th>";
                row += "<th>" + res[i].datum_vreme + "</th>";
                let btn = "<button class='btnDelete' data-id=" + res[i].id + ">Otkazi</button>";
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

$(document).on('click', '.btnDelete', function () {
    let treningId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/prijavljeni-treninzi/za-clana/" + treningId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + treningId + '"]').parent().parent().remove();
        },
        error: function () {
            alert("Greška prilikom brisanja treninga!");
        }
    });
});