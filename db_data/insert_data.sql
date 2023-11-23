insert into sites values ('ceri');
insert into sites values ('agrosciences');



insert into salles values ('c038', 'ceri');
insert into salles values ('c136', 'ceri');
insert into salles values ('c137', 'ceri');
insert into salles values ('c138', 'ceri');
insert into salles values ('amphi blaise', 'ceri');
insert into salles values ('amphi ada', 'ceri');

insert into salles values ('a01', 'agrosciences');
insert into salles values ('a02', 'agrosciences');



insert into matieres values ('architecture web');
insert into matieres values ('architecture cloud');
insert into matieres values ('cryptographie avancee');
insert into matieres values ('securite dans les reseaux');

insert into matieres values ('application d innovation');
insert into matieres values ('securite des services web');
insert into matieres values ('securite des systemes d information');
insert into matieres values ('application de securite avancee');

insert into matieres values ('design pattern');
insert into matieres values ('genie logiciel');
insert into matieres values ('systemes de exploitation');
insert into matieres values ('protocoles reseaux');

insert into matieres values ('toxicologie');
insert into matieres values ('microbiologie');
insert into matieres values ('flux hydriques');
insert into matieres values ('agronomie');

insert into matieres values ('hydrogeophysique');
insert into matieres values ('hydrologie appliquee');
insert into matieres values ('teledetection');
insert into matieres values ('pollution et decontamination');



insert into sections values ('m2 sicom');
insert into sections values ('m1 sicom');
insert into sections values ('l3 informatique');

insert into sections values ('m2 hse');
insert into sections values ('m1 hse');



insert into groupes values ('alternant');
insert into groupes values ('classique');



insert into professeurs values ('philippe', 'philippe@univ-avignon.fr');
insert into professeurs values ('robert', 'robert@univ-avignon.fr');
insert into professeurs values ('bernard', 'bernard@univ-avignon.fr'); 
insert into professeurs values ('chi', 'chi@univ-avignon.fr'); 
insert into professeurs values ('evelyne', 'evelyne@univ-avignon.fr');
insert into professeurs values ('jane', 'jane@univ-avignon.fr');

 
insert into cours (matiere, salle, section, groupe, dateDebut, dateFin, professeur) values ('application d innovation', 'c137', 'm2 sicom', 'alternant', '2023-11-16 08:30:00', '2023-11-16 11:30:00', 'philippe');
insert into cours (matiere, salle, section, groupe, dateDebut, dateFin, professeur) values ('securite des services web', 'c136', 'm2 sicom', 'classique', '2023-11-16 08:30:00', '2023-11-16 11:30:00', 'jane');

insert into cours (matiere, salle, section, groupe, dateDebut, dateFin, professeur) values ('architecture web', 'c138', 'm1 sicom', 'classique', '2023-11-16 10:00:00', '2023-11-16 13:00:00', 'philippe');
insert into cours (matiere, salle, section, groupe, dateDebut, dateFin, professeur) values ('architecture cloud', 'c138', 'm1 sicom', 'classique', '2023-11-16 13:00:00', '2023-11-16 16:00:00', 'robert');

insert into cours (matiere, salle, section, groupe, dateDebut, dateFin, professeur) values ('design pattern', 'c137', 'l3 informatique', 'alternant', '2023-11-16 14:30:00', '2023-11-16 17:30:00', 'philippe');
insert into cours (matiere, salle, section, groupe, dateDebut, dateFin, professeur) values ('protocoles reseaux', 'c136', 'l3 informatique', 'classique', '2023-11-16 16:00:00', '2023-11-16 19:00:00', 'jane');

insert into cours (matiere, salle, section, groupe, dateDebut, dateFin, professeur) values ('toxicologie', 'a01', 'm1 hse', 'classique', '2023-11-16 08:30:00', '2023-11-16 11:30:00', 'bernard');
insert into cours (matiere, salle, section, groupe, dateDebut, dateFin, professeur) values ('microbiologie', 'amphi blaise', 'm1 hse', 'classique', '2023-11-16T13:00:00', '2023-11-16T16:00:00', 'bernard');

insert into cours (matiere, salle, section, groupe, dateDebut, dateFin, professeur) values ('teledetection', 'c138', 'm1 hse', 'classique', '2023-11-16 08:30:00', '2023-11-16 11:30:00', 'chi');
insert into cours (matiere, salle, section, groupe, dateDebut, dateFin, professeur) values ('hydrogeophysique', 'a02', 'm2 hse', 'classique', '2023-11-16 13:00:00', '2023-11-16 16:00:00', 'chi');



