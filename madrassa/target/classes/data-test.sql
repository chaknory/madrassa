-- Script d'insertion simplifié pour tests
INSERT INTO annee_scolaire (libelle, date_debut, date_fin, active) VALUES ('2024-2025', '2024-09-01', '2025-06-30', true);
INSERT INTO niveau (code, libelle, ordre, cycle) VALUES ('CP', 'Cours Préparatoire', 1, 'Primaire');
INSERT INTO niveau (code, libelle, ordre, cycle) VALUES ('CE1', 'Cours Élémentaire 1', 2, 'Primaire');
INSERT INTO matiere (code, libelle, description, coefficient, couleur, actif) VALUES ('ARAB', 'Langue Arabe', 'Étude de la langue arabe', 3.0, '#FF6B35', true);
INSERT INTO personne (nom, prenom, date_naissance, sexe, email, type_personne, actif, date_creation, date_modification) VALUES ('Benali', 'Ahmed', '1980-03-15', 'M', 'ahmed.benali@madrassa.dz', 'ENSEIGNANT', true, '2024-01-01 08:00:00', '2024-01-01 08:00:00');
INSERT INTO enseignant (id_personne, numero_employe, date_embauche, specialite, statut, actif) VALUES (1, 'ENS001', '2020-09-01', 'Langue Arabe', 'TITULAIRE', true);
INSERT INTO classe (id_annee, id_niveau, id_enseignant_principal, nom_classe, effectif_max, salle) VALUES (1, 1, 1, 'CP-A', 25, 'Salle 101');
INSERT INTO eleve (nom, prenom, date_naissance, numero_eleve) VALUES ('Benaissa', 'Mohammed', '2014-06-15', 'ELV2024001');
INSERT INTO eleve (nom, prenom, date_naissance, numero_eleve) VALUES ('Zerrouki', 'Amina', '2013-09-22', 'ELV2024002');
INSERT INTO inscription (id_eleve, id_classe, date_inscription, statut) VALUES (1, 1, '2024-09-01', 'ACTIVE');
INSERT INTO inscription (id_eleve, id_classe, date_inscription, statut) VALUES (2, 1, '2024-09-01', 'ACTIVE');