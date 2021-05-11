DROP DATABASE IF EXISTS bibliotheque;

CREATE DATABASE IF NOT EXISTS bibliotheque;
USE bibliotheque;
# -----------------------------------------------------------------------------
#       TABLE : LIVRE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LIVRE
 (
   IDRES CHAR(32) NOT NULL  ,
   AUTEUR CHAR(32) NULL  ,
   ISBN CHAR(32) NULL  ,
   EDITEUR CHAR(32) NULL  
   , PRIMARY KEY (IDRES) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : EXEMPLAIRE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS EXEMPLAIRE
 (
   CODE_BARRE CHAR(32) NOT NULL  ,
   IDRES CHAR(32) NOT NULL  ,
   DATEDERETOUR CHAR(32) NULL  ,
   DATEDEPRET CHAR(32) NULL  
   , PRIMARY KEY (CODE_BARRE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : UTILISATEUR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS UTILISATEUR
 (
   NOM CHAR(32) NULL  ,
   CAUTION CHAR(32) NULL  ,
   IDUTILISATEUR CHAR(32) NOT NULL  ,
   PRENOM CHAR(32) NULL  ,
   EMAIL CHAR(32) NULL  ,
   TELEPHONE CHAR(32) NULL  ,
   PASSWORD CHAR(32) NULL  ,
   PHOTO CHAR(32) NULL  
   , PRIMARY KEY (IDUTILISATEUR) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ETUDIANT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ETUDIANT
 (
   IDUTILISATEUR CHAR(32) NOT NULL  ,
   ETABLISSEMENT CHAR(32) NULL  ,
   DATEDENAISSANCE CHAR(32) NULL  ,
   IDCARTEETUDIANT CHAR(32) NULL  ,
   ANNEEETUDE CHAR(32) NULL  
   , PRIMARY KEY (IDUTILISATEUR) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : REVUE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS REVUE
 (
   IDRES CHAR(32) NOT NULL  ,
   VOLUME CHAR(32) NULL  ,
   PARUTION CHAR(32) NULL  
   , PRIMARY KEY (IDRES) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : BIBLIOTHECAIRE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS BIBLIOTHECAIRE
 (
   CODE CHAR(32) NOT NULL  ,
   NOM CHAR(32) NULL  ,
   PRENOM CHAR(32) NULL  ,
   PASSWORD CHAR(32) NULL  
   , PRIMARY KEY (CODE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : EMPLACEMENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS EMPLACEMENT
 (
   TRAVÉE CHAR(32) NULL  ,
   ÉTAGÈRE CHAR(32) NULL  ,
   NIVEAU CHAR(32) NULL  ,
   ZONE CHAR(32) NOT NULL  
   , PRIMARY KEY (ZONE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : RESSOURCE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS RESSOURCE
 (
   ZONE CHAR(32) NOT NULL  ,
   TITRE CHAR(32) NULL  ,
   CAUTION CHAR(32) NULL  ,
   IDRES CHAR(32) NOT NULL  ,
   NBREPAGES CHAR(32) NULL  ,
   ETAT CHAR(32) NULL  ,
   RUBRIQUE CHAR(32) NULL  ,
   NBREDEXEMPLAIRES CHAR(32) NULL  
   , PRIMARY KEY (IDRES) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PARTICULIER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PARTICULIER
 (
   IDUTILISATEUR CHAR(32) NOT NULL  ,
   NISS CHAR(32) NULL  
   , PRIMARY KEY (IDUTILISATEUR) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ENREGISTRE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ENREGISTRE
 (
   IDUTILISATEUR CHAR(32) NOT NULL  ,
   CODE CHAR(32) NOT NULL  
   , PRIMARY KEY (IDUTILISATEUR,CODE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : AJOUTER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS AJOUTER
 (
   CODE CHAR(32) NOT NULL  ,
   IDRES CHAR(32) NOT NULL  
   , PRIMARY KEY (CODE,IDRES) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : RENDRE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS RENDRE
 (
   CODE_BARRE CHAR(32) NOT NULL  ,
   IDUTILISATEUR CHAR(32) NULL  
   , PRIMARY KEY (CODE_BARRE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : EMPRUNTER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS EMPRUNTER
 (
   CODE_BARRE CHAR(32) NOT NULL  ,
   IDUTILISATEUR CHAR(32) NULL  
   , PRIMARY KEY (CODE_BARRE) 
 ) 
 comment = "";


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE LIVRE 
  ADD FOREIGN KEY FK_LIVRE_RESSOURCE (IDRES)
      REFERENCES RESSOURCE (IDRES) ;


ALTER TABLE EXEMPLAIRE 
  ADD FOREIGN KEY FK_EXEMPLAIRE_RESSOURCE (IDRES)
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

