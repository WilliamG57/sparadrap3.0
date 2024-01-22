INSERT INTO personne (per_id,per_nom,per_prenom,per_telephone,per_email,per_adr,per_codepostal,per_ville) VALUES (1,'Dupont','Jean','0612345678','dupont.jean@gmail.com','123 place de la république','75001','Paris');
INSERT INTO personne (per_id,per_nom,per_prenom,per_telephone,per_email,per_adr,per_codepostal,per_ville) VALUES (2,'Martin','Marie','0789654321','Martin.Marie@gmail.com','456 avenue de la gare','92100','Boulogne');
INSERT INTO personne (per_id,per_nom,per_prenom,per_telephone,per_email,per_adr,per_codepostal,per_ville) VALUES (3,'Durand','Paul','0476543210','durand.paul@gmail.com','789 rue de la liberté','69002','Lyon');
INSERT INTO personne (per_id,per_nom,per_prenom,per_telephone,per_email,per_adr,per_codepostal,per_ville) VALUES (4,'aaa','aa','4567891234','aa.a@gmail.com','123 rue a','10000','abc');
INSERT INTO personne (per_id,per_nom,per_prenom,per_telephone,per_email,per_adr,per_codepostal,per_ville) VALUES (5,'bbb','bb','5678912345','bb.b@gmail.com','456 rue b','20000','efg');
INSERT INTO personne (per_id,per_nom,per_prenom,per_telephone,per_email,per_adr,per_codepostal,per_ville) VALUES (6,'ccc','cc','6789123456','cc.c@gmail.com','789 rue c','30000','hij');
INSERT INTO personne (per_id,per_nom,per_prenom,per_telephone,per_email,per_adr,per_codepostal,per_ville) VALUES (7,'zzz','zz','9876543219','z.zz@gmail.com','321 rue z','90000','xyz');
INSERT INTO personne (per_id,per_nom,per_prenom,per_telephone,per_email,per_adr,per_codepostal,per_ville) VALUES (8,'yyy','yy','8765432198','y.yy@gmail.com','654 rue y','80000','uvw');
INSERT INTO personne (per_id,per_nom,per_prenom,per_telephone,per_email,per_adr,per_codepostal,per_ville) VALUES (9,'xxx','xx','7654321987','x.xx@gmail.com','987 rue x','70000','rst');

INSERT INTO mutuelle (mut_id, nom) VALUES (1,'CCMO');
INSERT INTO mutuelle (mut_id, nom) VALUES (2,'Mutami');
INSERT INTO mutuelle (mut_id, nom) VALUES (3,'GFP');


INSERT INTO medecin (med_agreement,per_id) VALUES (458,4);
INSERT INTO medecin (med_agreement,per_id) VALUES (126,5);
INSERT INTO medecin (med_agreement,per_id) VALUES (824,6);

INSERT INTO specialiste (specialite,per_id) VALUES ('somnoliste',7);
INSERT INTO specialiste (specialite,per_id) VALUES ('ophtalmologiste',8);
INSERT INTO specialiste (specialite,per_id) VALUES ('urologiste',9);

INSERT INTO categorie (cat_id,cat_nom) VALUES (1,'anti-douleur');
INSERT INTO categorie (cat_id,cat_nom) VALUES (2,'somnifere');
INSERT INTO categorie (cat_id,cat_nom) VALUES (3,'goutte');
INSERT INTO categorie (cat_id,cat_nom) VALUES (4,'viagra');


INSERT INTO client (cli_secu,cli_datenaissance,per_id,spe_id,med_id,mut_id) VALUES ('123456789123456','1988-08-01',1,7,4,1);
INSERT INTO client (cli_secu,cli_datenaissance,per_id,spe_id,med_id,mut_id) VALUES ('234567891234567','2000-03-01',2,8,5,2);
INSERT INTO client (cli_secu,cli_datenaissance,per_id,spe_id,med_id,mut_id) VALUES ('345678912345678','1958-02-01',3,9,6,3);

INSERT INTO medicament (medi_id, medi_nom, medi_prix, medi_stock, cat_id)
VALUES (1, "doliprane", 4.50, 50, 1);
INSERT INTO medicament (medi_id, medi_nom, medi_prix, medi_stock, cat_id)
VALUES (2, "millepertuis", 7.90, 50, 2);
INSERT INTO medicament (medi_id, medi_nom, medi_prix, medi_stock, cat_id)
VALUES (3, "collyre", 3.39, 50, 3);
INSERT INTO medicament (medi_id, medi_nom, medi_prix, medi_stock, cat_id)
VALUES (4, "sildenafil", 9.99, 50, 4);