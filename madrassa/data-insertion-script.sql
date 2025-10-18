-- =====================================================
-- Script SQL d'insertion de données - Application Madrassa
-- =====================================================
-- Génération de données pour 5 élèves et leurs relations
-- Date de création: 2025-10-12
-- =====================================================

-- =====================================================
-- 1. ANNÉE SCOLAIRE
-- =====================================================
INSERT INTO annee_scolaire (libelle, date_debut, date_fin, active) VALUES
('2024-2025', '2024-09-01', '2025-06-30', true),
('2023-2024', '2023-09-01', '2024-06-30', false);

-- =====================================================
-- 2. NIVEAUX
-- =====================================================
INSERT INTO niveau (code, libelle, ordre, cycle) VALUES
('CP', 'Cours Préparatoire', 1, 'Primaire'),
('CE1', 'Cours Élémentaire 1', 2, 'Primaire'),
('CE2', 'Cours Élémentaire 2', 3, 'Primaire'),
('CM1', 'Cours Moyen 1', 4, 'Primaire'),
('CM2', 'Cours Moyen 2', 5, 'Primaire'),
('6EME', 'Sixième', 6, 'Collège'),
('5EME', 'Cinquième', 7, 'Collège');

-- =====================================================
-- 3. MATIÈRES
-- =====================================================
INSERT INTO matiere (code, libelle, description, coefficient, couleur, actif) VALUES
('ARAB', 'Langue Arabe', 'Étude de la langue arabe classique et moderne', 3.0, '#FF6B35', true),
('CORAN', 'Sciences Coraniques', 'Mémorisation et étude du Saint Coran', 4.0, '#4ECDC4', true),
('HADITH', 'Sciences du Hadith', 'Étude des traditions prophétiques', 2.0, '#45B7D1', true),
('FIQH', 'Jurisprudence Islamique', 'Étude du droit islamique (Fiqh)', 3.0, '#96CEB4', true),
('MATH', 'Mathématiques', 'Calcul, géométrie et algèbre', 3.0, '#FFEAA7', true),
('HIST', 'Histoire Islamique', 'Histoire des civilisations islamiques', 2.0, '#DDA0DD', true),
('FRANC', 'Français', 'Langue française', 2.0, '#FF7675', true);

-- =====================================================
-- 4. PERSONNES (Pour les enseignants)
-- =====================================================
INSERT INTO personne (nom, prenom, date_naissance, sexe, email, telephone, telephone_mobile, adresse, code_postal, ville, pays, type_personne, actif, date_creation, date_modification) VALUES
('Benali', 'Ahmed', '1980-03-15', 'M', 'ahmed.benali@madrassa.dz', '021234567', '0555123456', '15 Rue des Martyrs', '16000', 'Alger', 'Algérie', 'ENSEIGNANT', true, '2024-01-01 08:00:00', '2024-01-01 08:00:00'),
('Khadija', 'Fatima', '1985-07-22', 'F', 'fatima.khadija@madrassa.dz', '021234568', '0555123457', '23 Avenue de l''Indépendance', '16000', 'Alger', 'Algérie', 'ENSEIGNANT', true, '2024-01-01 08:00:00', '2024-01-01 08:00:00'),
('Messaoudi', 'Omar', '1978-11-10', 'M', 'omar.messaoudi@madrassa.dz', '021234569', '0555123458', '8 Rue El Moudjahid', '16000', 'Alger', 'Algérie', 'ENSEIGNANT', true, '2024-01-01 08:00:00', '2024-01-01 08:00:00'),
('Bouazza', 'Aicha', '1982-05-18', 'F', 'aicha.bouazza@madrassa.dz', '021234570', '0555123459', '45 Boulevard Mohamed V', '16000', 'Alger', 'Algérie', 'ENSEIGNANT', true, '2024-01-01 08:00:00', '2024-01-01 08:00:00'),
('Hamidi', 'Youssef', '1975-09-25', 'M', 'youssef.hamidi@madrassa.dz', '021234571', '0555123460', '12 Rue de la Liberté', '16000', 'Alger', 'Algérie', 'DIRECTEUR', true, '2024-01-01 08:00:00', '2024-01-01 08:00:00');

-- =====================================================
-- 5. ENSEIGNANTS
-- =====================================================
INSERT INTO enseignant (id_personne, numero_employe, date_embauche, specialite, diplome, statut, volume_horaire_hebdo, actif) VALUES
(1, 'ENS001', '2020-09-01', 'Langue Arabe', 'Master en Langue et Littérature Arabes', 'TITULAIRE', 18.0, true),
(2, 'ENS002', '2019-09-01', 'Sciences Coraniques', 'Ijaza en Sciences Coraniques', 'TITULAIRE', 20.0, true),
(3, 'ENS003', '2021-09-01', 'Mathématiques', 'Licence en Mathématiques', 'CONTRACTUEL', 15.0, true),
(4, 'ENS004', '2018-09-01', 'Sciences Islamiques', 'Master en Sciences Islamiques', 'TITULAIRE', 16.0, true);

-- =====================================================
-- 6. CLASSES
-- =====================================================
INSERT INTO classe (id_annee, id_niveau, id_enseignant_principal, nom_classe, effectif_max, salle, commentaire) VALUES
(1, 1, 1, 'CP-A', 25, 'Salle 101', 'Classe de cours préparatoire - Section A'),
(1, 2, 2, 'CE1-A', 25, 'Salle 102', 'Classe de CE1 - Section A'),
(1, 6, 3, '6EME-A', 30, 'Salle 201', 'Classe de sixième - Section A'),
(1, 7, 4, '5EME-A', 30, 'Salle 202', 'Classe de cinquième - Section A');

-- =====================================================
-- 7. ÉLÈVES (5 élèves avec profils variés)
-- =====================================================
INSERT INTO eleve (nom, prenom, date_naissance, numero_eleve) VALUES
('Benaissa بن عيسى', 'Mohammed محمد', '2014-06-15', 'ELV2024001'),
('Zerrouki زروقي', 'Amina أمينة', '2013-09-22', 'ELV2024002'),
('Lahlou لحلو', 'Yacine ياسين', '2012-11-08', 'ELV2024003'),
('Brahimi براهيمي', 'Khadija خديجة', '2011-04-12', 'ELV2024004'),
('Chouaib شعيب', 'Omar عمر', '2010-12-03', 'ELV2024005');

-- =====================================================
-- 8. INSCRIPTIONS (Élèves dans leurs classes respectives)
-- =====================================================
INSERT INTO inscription (id_eleve, id_classe, date_inscription, date_fin, statut, commentaire) VALUES
(1, 1, '2024-09-01', '2025-06-30', 'ACTIVE', 'Inscription en CP - Première année'),
(2, 2, '2024-09-01', '2025-06-30', 'ACTIVE', 'Inscription en CE1 - Deuxième année dans l''école'),
(3, 3, '2024-09-01', '2025-06-30', 'ACTIVE', 'Inscription en 6ème - Transition vers le collège'),
(4, 4, '2024-09-01', '2025-06-30', 'ACTIVE', 'Inscription en 5ème - Élève brillante'),
(5, 4, '2024-09-01', '2025-06-30', 'ACTIVE', 'Inscription en 5ème - Élève assidu');

-- =====================================================
-- 9. COURS (Matières enseignées dans chaque classe)
-- =====================================================
INSERT INTO cours (id_classe, id_matiere, id_enseignant, id_annee, heures_semaine, coefficient, salle) VALUES
-- Cours pour CP-A (classe 1)
(1, 1, 1, 1, 6.0, 3.0, 'Salle 101'), -- Arabe
(1, 2, 2, 1, 4.0, 4.0, 'Salle 101'), -- Coran
(1, 5, 3, 1, 4.0, 3.0, 'Salle 101'), -- Maths

-- Cours pour CE1-A (classe 2)
(2, 1, 1, 1, 6.0, 3.0, 'Salle 102'), -- Arabe
(2, 2, 2, 1, 4.0, 4.0, 'Salle 102'), -- Coran
(2, 5, 3, 1, 5.0, 3.0, 'Salle 102'), -- Maths
(2, 7, 4, 1, 3.0, 2.0, 'Salle 102'), -- Français

-- Cours pour 6EME-A (classe 3)
(3, 1, 1, 1, 5.0, 3.0, 'Salle 201'), -- Arabe
(3, 2, 2, 1, 3.0, 4.0, 'Salle 201'), -- Coran
(3, 3, 4, 1, 2.0, 2.0, 'Salle 201'), -- Hadith
(3, 4, 4, 1, 3.0, 3.0, 'Salle 201'), -- Fiqh
(3, 5, 3, 1, 4.0, 3.0, 'Salle 201'), -- Maths
(3, 6, 4, 1, 2.0, 2.0, 'Salle 201'), -- Histoire
(3, 7, 4, 1, 3.0, 2.0, 'Salle 201'), -- Français

-- Cours pour 5EME-A (classe 4)
(4, 1, 1, 1, 5.0, 3.0, 'Salle 202'), -- Arabe
(4, 2, 2, 1, 3.0, 4.0, 'Salle 202'), -- Coran
(4, 3, 4, 1, 3.0, 2.0, 'Salle 202'), -- Hadith
(4, 4, 4, 1, 4.0, 3.0, 'Salle 202'), -- Fiqh
(4, 5, 3, 1, 4.0, 3.0, 'Salle 202'), -- Maths
(4, 6, 4, 1, 3.0, 2.0, 'Salle 202'), -- Histoire
(4, 7, 4, 1, 3.0, 2.0, 'Salle 202'); -- Français

-- =====================================================
-- 10. PÉRIODES SCOLAIRES
-- =====================================================
INSERT INTO periode (id_annee, libelle, numero_periode, date_debut, date_fin, cloturee) VALUES
(1, '1er Trimestre 2024-2025', 1, '2024-09-01', '2024-12-20', false),
(1, '2ème Trimestre 2024-2025', 2, '2025-01-08', '2025-03-28', false),
(1, '3ème Trimestre 2024-2025', 3, '2025-04-15', '2025-06-30', false);

-- =====================================================
-- 11. TYPES D'ÉVALUATION
-- =====================================================
INSERT INTO type_evaluation (code, libelle, description, coefficient, compte_moyenne) VALUES
('CTRL', 'Contrôle', 'Contrôle en classe', 1.0, true),
('DEVOIR', 'Devoir Surveillé', 'Devoir surveillé', 2.0, true),
('EXAMEN', 'Examen', 'Examen trimestriel', 3.0, true),
('ORAL', 'Interrogation Orale', 'Interrogation orale', 1.0, true),
('RECIT', 'Récitation', 'Récitation du Coran', 2.0, true);

-- =====================================================
-- 12. ÉVALUATIONS (Quelques évaluations pour le 1er trimestre)
-- =====================================================
INSERT INTO evaluation (id_classe, id_matiere, type, date_evaluation, coefficient) VALUES
-- Évaluations pour CP-A (classe 1)
(1, 1, 'Contrôle Alphabet Arabe', '2024-10-15', 1.0),
(1, 2, 'Récitation Sourate Al-Fatiha', '2024-10-20', 2.0),
(1, 5, 'Contrôle Additions', '2024-10-25', 1.0),

-- Évaluations pour CE1-A (classe 2)
(2, 1, 'Contrôle Grammaire Arabe', '2024-10-16', 1.0),
(2, 2, 'Récitation Sourate Al-Ikhlass', '2024-10-21', 2.0),
(2, 5, 'Devoir Tables de Multiplication', '2024-10-26', 2.0),

-- Évaluations pour 6EME-A (classe 3)
(3, 1, 'Devoir Poésie Arabe', '2024-10-17', 2.0),
(3, 2, 'Récitation Sourate Yasin', '2024-10-22', 2.0),
(3, 3, 'Contrôle Hadith', '2024-10-18', 1.0),

-- Évaluations pour 5EME-A (classe 4)
(4, 4, 'Examen Fiqh', '2024-10-30', 3.0),
(4, 5, 'Devoir Mathématiques', '2024-10-28', 2.0);

-- =====================================================
-- 13. NOTES (Notes des élèves pour les évaluations)
-- =====================================================
INSERT INTO note (id_evaluation, id_eleve, valeur, absent, dispense, appreciation, date_saisie, date_modification) VALUES
-- Notes pour Mohammed (CP-A - élève 1)
(1, 1, 16.0, false, false, 'Très bon travail, continue ainsi', '2024-10-15 15:30:00', '2024-10-15 15:30:00'),
(2, 1, 18.0, false, false, 'Excellente récitation, Tajwid parfait', '2024-10-20 16:00:00', '2024-10-20 16:00:00'),
(3, 1, 14.0, false, false, 'Quelques erreurs de calcul à corriger', '2024-10-25 15:45:00', '2024-10-25 15:45:00'),

-- Notes pour Amina (CE1-A - élève 2)
(4, 2, 17.0, false, false, 'Très bonne maîtrise des pronoms', '2024-10-16 16:15:00', '2024-10-16 16:15:00'),
(5, 2, 19.0, false, false, 'Récitation exemplaire, félicitations', '2024-10-21 15:45:00', '2024-10-21 15:45:00'),
(6, 2, 15.0, false, false, 'Tables bien apprises, petit effort sur la rapidité', '2024-10-26 16:30:00', '2024-10-26 16:30:00'),

-- Notes pour Yacine (6EME-A - élève 3)
(7, 3, 13.0, false, false, 'Analyse correcte mais manque de profondeur', '2024-10-17 17:00:00', '2024-10-17 17:00:00'),
(8, 3, 16.0, false, false, 'Bonne récitation, améliorer la fluidité', '2024-10-22 16:15:00', '2024-10-22 16:15:00'),
(9, 3, 12.0, false, false, 'Revoir les chaînes de transmission', '2024-10-18 16:45:00', '2024-10-18 16:45:00'),

-- Notes pour Khadija (5EME-A - élève 4)
(10, 4, 18.0, false, false, 'Excellente maîtrise du Fiqh, très bon niveau', '2024-10-30 17:30:00', '2024-10-30 17:30:00'),
(11, 4, 17.0, false, false, 'Très bon niveau en mathématiques', '2024-10-28 17:15:00', '2024-10-28 17:15:00'),

-- Notes pour Omar (5EME-A - élève 5)
(10, 5, 15.0, false, false, 'Bon niveau, continuer les efforts', '2024-10-30 17:30:00', '2024-10-30 17:30:00'),
(11, 5, 13.0, false, false, 'Difficultés en fractions, rattrapage conseillé', '2024-10-28 17:15:00', '2024-10-28 17:15:00');

-- =====================================================
-- 14. QUELQUES ABSENCES (Exemples réalistes)
-- =====================================================
INSERT INTO absence (id_eleve, id_cours, date_absence, heure_debut, heure_fin, justifie, motif, piece_justificative, commentaire, date_saisie) VALUES
(1, 1, '2024-10-05', '08:00:00', '09:00:00', true, 'Rendez-vous médical', 'Certificat médical', 'Visite chez le pédiatre', '2024-10-05 17:00:00'),
(3, 7, '2024-10-12', '10:00:00', '11:00:00', false, 'Retard non justifié', null, 'Arrivé en retard sans excuse', '2024-10-12 11:15:00'),
(5, 10, '2024-10-18', '14:00:00', '16:00:00', true, 'Maladie', 'Certificat médical', 'Grippe', '2024-10-19 08:00:00');

-- =====================================================
-- 15. QUELQUES RETARDS
-- =====================================================
INSERT INTO retard (id_eleve, id_cours, date_retard, heure_arrivee, duree_minutes, justifie, motif) VALUES
(2, 4, '2024-10-08', '08:15:00', 15, true, 'Transport en commun - Bus en retard'),
(3, 8, '2024-10-14', '09:20:00', 20, false, 'Réveil tardif - Pas d''excuse valable'),
(4, 11, '2024-10-22', '14:10:00', 10, true, 'Embouteillages - Circulation dense');

-- =====================================================
-- RÉSUMÉ DES DONNÉES INSÉRÉES
-- =====================================================
-- ✅ 2 Années scolaires
-- ✅ 7 Niveaux (CP à 5ème)
-- ✅ 7 Matières (Arabe, Coran, Hadith, Fiqh, Maths, Histoire, Français)
-- ✅ 5 Personnes (enseignants)
-- ✅ 4 Enseignants
-- ✅ 4 Classes
-- ✅ 5 Élèves avec profils variés (âges différents)
-- ✅ 5 Inscriptions (élèves dans leurs classes)
-- ✅ 15 Cours (matières dans les classes)
-- ✅ 3 Périodes scolaires
-- ✅ 5 Types d'évaluation
-- ✅ 11 Évaluations
-- ✅ 13 Notes
-- ✅ 3 Absences
-- ✅ 3 Retards
-- =====================================================

-- Vérification des données insérées
SELECT 'Élèves inscrits' as Type, COUNT(*) as Nombre FROM eleve
UNION ALL
SELECT 'Inscriptions actives', COUNT(*) FROM inscription WHERE statut = 'ACTIVE'
UNION ALL
SELECT 'Cours programmés', COUNT(*) FROM cours
UNION ALL
SELECT 'Évaluations', COUNT(*) FROM evaluation
UNION ALL
SELECT 'Notes attribuées', COUNT(*) FROM note
UNION ALL
SELECT 'Absences enregistrées', COUNT(*) FROM absence
UNION ALL
SELECT 'Retards enregistrés', COUNT(*) FROM retard;