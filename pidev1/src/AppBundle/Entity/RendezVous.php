<?php

namespace AppBundle\Entity;

/**
 * RendezVous
 */
class RendezVous
{
    /**
     * @var string
     */
    private $nom;

    /**
     * @var string
     */
    private $prenom;

    /**
     * @var \DateTime
     */
    private $dateNaissance;

    /**
     * @var integer
     */
    private $telephone;

    /**
     * @var string
     */
    private $adresse;

    /**
     * @var \DateTime
     */
    private $dateReservation;

    /**
     * @var \AppBundle\Entity\Users
     */
    private $cin;

    /**
     * @var \AppBundle\Entity\Users
     */
    private $idMedecin;


    /**
     * Set nom
     *
     * @param string $nom
     *
     * @return RendezVous
     */
    public function setNom($nom)
    {
        $this->nom = $nom;

        return $this;
    }

    /**
     * Get nom
     *
     * @return string
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * Set prenom
     *
     * @param string $prenom
     *
     * @return RendezVous
     */
    public function setPrenom($prenom)
    {
        $this->prenom = $prenom;

        return $this;
    }

    /**
     * Get prenom
     *
     * @return string
     */
    public function getPrenom()
    {
        return $this->prenom;
    }

    /**
     * Set dateNaissance
     *
     * @param \DateTime $dateNaissance
     *
     * @return RendezVous
     */
    public function setDateNaissance($dateNaissance)
    {
        $this->dateNaissance = $dateNaissance;

        return $this;
    }

    /**
     * Get dateNaissance
     *
     * @return \DateTime
     */
    public function getDateNaissance()
    {
        return $this->dateNaissance;
    }

    /**
     * Set telephone
     *
     * @param integer $telephone
     *
     * @return RendezVous
     */
    public function setTelephone($telephone)
    {
        $this->telephone = $telephone;

        return $this;
    }

    /**
     * Get telephone
     *
     * @return integer
     */
    public function getTelephone()
    {
        return $this->telephone;
    }

    /**
     * Set adresse
     *
     * @param string $adresse
     *
     * @return RendezVous
     */
    public function setAdresse($adresse)
    {
        $this->adresse = $adresse;

        return $this;
    }

    /**
     * Get adresse
     *
     * @return string
     */
    public function getAdresse()
    {
        return $this->adresse;
    }

    /**
     * Set dateReservation
     *
     * @param \DateTime $dateReservation
     *
     * @return RendezVous
     */
    public function setDateReservation($dateReservation)
    {
        $this->dateReservation = $dateReservation;

        return $this;
    }

    /**
     * Get dateReservation
     *
     * @return \DateTime
     */
    public function getDateReservation()
    {
        return $this->dateReservation;
    }

    /**
     * Set cin
     *
     * @param \AppBundle\Entity\Users $cin
     *
     * @return RendezVous
     */
    public function setCin(\AppBundle\Entity\Users $cin)
    {
        $this->cin = $cin;

        return $this;
    }

    /**
     * Get cin
     *
     * @return \AppBundle\Entity\Users
     */
    public function getCin()
    {
        return $this->cin;
    }

    /**
     * Set idMedecin
     *
     * @param \AppBundle\Entity\Users $idMedecin
     *
     * @return RendezVous
     */
    public function setIdMedecin(\AppBundle\Entity\Users $idMedecin = null)
    {
        $this->idMedecin = $idMedecin;

        return $this;
    }

    /**
     * Get idMedecin
     *
     * @return \AppBundle\Entity\Users
     */
    public function getIdMedecin()
    {
        return $this->idMedecin;
    }
}

