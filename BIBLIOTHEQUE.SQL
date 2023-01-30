DROP DATABASE IF EXISTS bibliotheque;

CREATE DATABASE IF NOT EXISTS bibliotheque;
USE bibliotheque;
# -----------------------------------------------------------------------------
#       TABLE : LIVRE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LIVRE
 (
   IDRES VARCHAR(32) NOT NULL  ,
   AUTEUR VARCHAR(32) NULL  ,
   ISBN VARCHAR(32) NULL  ,
   EDITEUR VARCHAR(32) NULL  
   , PRIMARY KEY (IDRES) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : EXEMPLAIRE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS EXEMPLAIRE
 (
   CODE_BARRE VARCHAR(32) NOT NULL  
   , PRIMARY KEY (CODE_BARRE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : UTILISATEUR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS UTILISATEUR
 (
   NOM VARCHAR(32) NULL  ,
   CAUTION VARCHAR(32) NULL  ,
   IDUTILISATEUR REAL(5,2) NOT NULL  ,
   PRENOM VARCHAR(32) NULL  ,
   EMAIL VARCHAR(32) NULL  ,
   TELEPHONE VARCHAR(32) NULL  ,
   PASSWORD VARCHAR(32) NULL  ,
   PHOTO VARCHAR(32) NULL  
   , PRIMARY KEY (IDUTILISATEUR) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ETUDIANT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ETUDIANT
 (
   IDUTILISATEUR REAL(5,2) NOT NULL  ,
   ETABLISSEMENT VARCHAR(32) NULL  ,
   DATEDENAISSANCE VARCHAR(32) NULL  ,
   IDCARTEETUDIANT VARCHAR(32) NULL  ,
   ANNEEETUDE VARCHAR(32) NULL  
   , PRIMARY KEY (IDUTILISATEUR) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : REVUE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS REVUE
 (
   IDRES VARCHAR(32) NOT NULL  ,
   VOLUME VARCHAR(32) NULL  ,
   PARUTION VARCHAR(32) NULL  
   , PRIMARY KEY (IDRES) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : BIBLIOTHECAIRE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS BIBLIOTHECAIRE
 (
   CODE VARCHAR(32) NOT NULL  ,
   NOM VARCHAR(32) NULL  ,
   PRENOM VARCHAR(32) NULL  ,
   PASSWORD VARCHAR(32) NULL  
   , PRIMARY KEY (CODE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : EMPLACEMENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS EMPLACEMENT
 (
   TRAV�E VARCHAR(32) NULL  ,
   �TAG�RE VARCHAR(32) NULL  ,
   NIVEAU VARCHAR(32) NULL  ,
   ZONE VARCHAR(32) NOT NULL  
   , PRIMARY KEY (ZONE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : RESSOURCE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS RESSOURCE
 (
   ZONE VARCHAR(32) NOT NULL  ,
   TITRE VARCHAR(32) NULL  ,
   CAUTION VARCHAR(32) NULL  ,
   IDRES VARCHAR(32) NOT NULL  ,
   NBREPAGES VARCHAR(32) NULL  ,
   ETAT VARCHAR(32) NULL  ,
   RUBRIQUE VARCHAR(32) NULL  ,
   NBREDEXEMPLAIRES VARCHAR(32) NULL  
   , PRIMARY KEY (IDRES) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PARTICULIER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PARTICULIER
 (
   IDUTILISATEUR REAL(5,2) NOT NULL  ,
   NISS VARCHAR(32) NULL  
   , PRIMARY KEY (IDUTILISATEUR) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ENREGISTRE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ENREGISTRE
 (
   IDUTILISATEUR REAL(5,2) NOT NULL  ,
   CODE VARCHAR(32) NOT NULL  
   , PRIMARY KEY (IDUTILISATEUR,CODE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : POSSEDER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS POSSEDER
 (
   IDRES VARCHAR(32) NOT NULL  ,
   CODE_BARRE VARCHAR(32) NULL  
   , PRIMARY KEY (IDRES) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : AJOUTER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS AJOUTER
 (
   CODE VARCHAR(32) NOT NULL  ,
   IDRES VARCHAR(32) NOT NULL  
   , PRIMARY KEY (CODE,IDRES) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : RENDRE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS RENDRE
 (
   CODE_BARRE VARCHAR(32) NOT NULL  ,
   IDUTILISATEUR REAL(5,2) NULL  ,
   DATE_RETOUR VARCHAR(32) NULL  
   , PRIMARY KEY (CODE_BARRE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : EMPRUNTER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS EMPRUNTER
 (
   CODE_BARRE VARCHAR(32) NOT NULL  ,
   IDUTILISATEUR REAL(5,2) NULL  ,
   DATE_PRET VARCHAR(32) NULL  
   , PRIMARY KEY (CODE_BARRE) 
 ) 
 comment = "";


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE LIVRE 
  ADD FOREIGN KEY FK_LIVRE_RESSOURCE (IDRES)
      REFERENCES RESSOURCE (IDRES) ;


ALTER TABLE ETUDIANT 
  ADD FOREIGN KEY FK_ETUDIANT_UTILISATEUR (IDUTILISATEUR)
      REFERENCES UTILISATEUR (IDUTILISATEUR) ;


ALTER TABLE REVUE 
  ADD FOREIGN KEY FK_REVUE_RESSOURCE (IDRES)
      REFERENCES RESSOURCE (IDRES) ;


ALTER TABLE RESSOURCE 
  ADD FOREIGN KEY FK_RESSOURCE_EMPLACEMENT (ZONE)
      REFERENCES EMPLACEMENT (ZONE) ;


ALTER TABLE PARTICULIER 
  ADD FOREIGN KEY FK_PARTICULIER_UTILISATEUR (IDUTILISATEUR)
      REFERENCES UTILISATEUR (IDUTILISATEUR) ;


ALTER TABLE ENREGISTRE 
  ADD FOREIGN KEY FK_ENREGISTRE_UTILISATEUR (IDUTILISATEUR)
      REFERENCES UTILISATEUR (IDUTILISATEUR) ;


ALTER TABLE ENREGISTRE 
  ADD FOREIGN KEY FK_ENREGISTRE_BIBLIOTHECAIRE (CODE)
      REFERENCES BIBLIOTHECAIRE (CODE) ;


ALTER TABLE POSSEDER 
  ADD FOREIGN KEY FK_POSSEDER_RESSOURCE (IDRES)
      REFERENCES RESSOURCE (IDRES) ;


ALTER TABLE POSSEDER 
  ADD FOREIGN KEY FK_POSSEDER_EXEMPLAIRE (CODE_BARRE)
      REFERENCES EXEMPLAIRE (CODE_BARRE) ;


ALTER TABLE AJOUTER 
  ADD FOREIGN KEY FK_AJOUTER_BIBLIOTHECAIRE (CODE)
      REFERENCES BIBLIOTHECAIRE (CODE) ;


ALTER TABLE AJOUTER 
  ADD FOREIGN KEY FK_AJOUTER_RESSOURCE (IDRES)
      REFERENCES RESSOURCE (IDRES) ;


ALTER TABLE RENDRE 
  ADD FOREIGN KEY FK_RENDRE_EXEMPLAIRE (CODE_BARRE)
      REFERENCES EXEMPLAIRE (CODE_BARRE) ;


ALTER TABLE RENDRE 
  ADD FOREIGN KEY FK_RENDRE_UTILISATEUR (IDUTILISATEUR)
      REFERENCES UTILISATEUR (IDUTILISATEUR) ;


ALTER TABLE EMPRUNTER 
  ADD FOREIGN KEY FK_EMPRUNTER_EXEMPLAIRE (CODE_BARRE)
      REFERENCES EXEMPLAIRE (CODE_BARRE) ;


ALTER TABLE EMPRUNTER 
  ADD FOREIGN KEY FK_EMPRUNTER_UTILISATEUR (IDUTILISATEUR)
      REFERENCES UTILISATEUR (IDUTILISATEUR) ;

