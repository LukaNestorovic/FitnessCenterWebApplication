Insert into Administrator (korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,uloga,aktivan) values ('Luka123','123123','Luka','Nestorovic','065444','luka@gmail.com','2001-02-12','Administrator',true);

Insert into Clan (korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,uloga,aktivan) values ('Luka123','123123','Luka','Nestorovic','065444','luka@gmail.com','2001-02-12','Clan',true);
Insert into Clan (korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,uloga,aktivan) values ('Luka12','12312','Luka','Nestorovic','06544445','luka12@gmail.com','2002-02-12','Clan',true);

Insert into Fitnes_Centar (naziv,adresa,email,broj_telefona) values ('FitnesCentar','Drinske divizije bb','fitnes@gmail.com','05452');

Insert into Trener (korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,uloga,aktivan,prosecna_ocena,fitnes_centar_id) values ('Luka123','123123','Luka','Nestorovic','065444','luka@gmail.com','2001-02-12','Trener',true,5,1);
Insert into Trener (korisnicko_ime,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja,uloga,aktivan,prosecna_ocena,fitnes_centar_id) values ('Luka1','12312','Luk','Nestorovic','06544','lu@gmail.com','2001-02-12','Trener',true,5,1);


Insert into Trening (naziv,opis,tip_treninga,trajanje,trener_id) values ('Kardio','Trcanje','Kardio',2,1);
Insert into Trening (naziv,opis,tip_treninga,trajanje,trener_id) values ('Limbo','Provlacenje','Limbo',3,1);
Insert into Trening (naziv,opis,tip_treninga,trajanje,trener_id) values ('Aerobik','Istezanje','Aerobik',1,1);
Insert into Trening (naziv,opis,tip_treninga,trajanje,trener_id) values ('Kardi','Trcanj','Kardi',2,2);


Insert into Sala (kapacitet,oznaka_sale,fitnes_centar_id) values (200,'101',1);

Insert into Termin (cena,datum_vreme,fitnes_centar_id,trening_id,odradjeni_trening_id,ocena_id,clan_id,sala_id) values (500,'2021-05-01',1,1,1,1,1,1);
Insert into Termin (cena,datum_vreme,fitnes_centar_id,trening_id,odradjeni_trening_id,ocena_id,clan_id,sala_id) values (1000,'2021-05-03',1,1,1,1,1,1);
Insert into Termin (cena,datum_vreme,fitnes_centar_id,trening_id,odradjeni_trening_id,ocena_id,clan_id,sala_id) values (700,'2021-05-01',1,2,1,1,1,1);
Insert into Termin (cena,datum_vreme,fitnes_centar_id,trening_id,odradjeni_trening_id,ocena_id,clan_id,sala_id) values (200,'2021-05-03',1,2,1,1,1,1);


Insert into Odradjeni_Trening (ocena,trening_id,termin_id,clan_id) values (5,1,1,1);
Insert into Odradjeni_Trening (ocena,trening_id,termin_id,clan_id) values (null,2,3,2);
Insert into Odradjeni_Trening (ocena,trening_id,termin_id,clan_id) values (null,1,2,1);
Insert into Odradjeni_Trening (ocena,trening_id,termin_id,clan_id) values (4,3,3,1);