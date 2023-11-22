create table sites(
	name varchar(255),
	primary key (name)
	);

create table salles(
	name varchar(255), 
	site varchar(255),
	primary key (name),
	foreign key (site) references sites(name)
	);

create table matieres(
	name varchar(255),
	primary key (name)
	);


create table sections(
	name varchar(255),
	primary key (name)
	);

create table groupes(
	name varchar(255),
	primary key (name)
	);

create table professeurs(
	name varchar(255), 
	contact varchar(255),
	primary key (name)
	);

create table cours(
	id mediumint not null AUTO_INCREMENT,
	matiere varchar(255), 
	salle varchar(255), 
	section varchar(255), 
	groupe varchar(255), 
	dateDebut datetime,
	dateFin datetime,
	professeur varchar(255),
	PRIMARY KEY (id),
	foreign key (matiere) references matieres(name), 
	foreign key (salle) references salles(name),
	foreign key (section) references sections(name),
	foreign key (groupe) references groupes(name),
	foreign key (professeur) references professeurs(name)
	);
