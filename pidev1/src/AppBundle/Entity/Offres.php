<?php

namespace AppBundle\Entity;

/**
 * Offres
 */
class Offres
{
    /**
     * @var \DateTime
     */
    private $dateDebut;

    /**
     * @var \DateTime
     */
    private $dateFin;

    /**
     * @var string
     */
    private $descrOffre;

    /**
     * @var float
     */
    private $prix;

    /**
     * @var string
     */
    private $nom;


    /**
     * Set dateDebut
     *
     * @param \DateTime $dateDebut
     *
     * @return Offres
     */
    public function setDateDebut($dateDebut)
    {
        $this->dateDebut = $dateDebut;

        return $this;
    }

    /**
     * Get dateDebut
     *
     * @return \DateTime
     */
    public function getDateDebut()
    {
        return $this->dateDebut;
    }

    /**
     * Set dateFin
     *
     * @param \DateTime $dateFin
     *
     * @return Offres
     */
    public function setDateFin($dateFin)
    {
        $this->dateFin = $dateFin;

        return $this;
    }

    /**
     * Get dateFin
     *
     * @return \DateTime
     */
    public function getDateFin()
    {
        return $this->dateFin;
    }

    /**
     * Set descrOffre
     *
     * @param string $descrOffre
     *
     * @return Offres
     */
    public function setDescrOffre($descrOffre)
    {
        $this->descrOffre = $descrOffre;

        return $this;
    }

    /**
     * Get descrOffre
     *
     * @return string
     */
    public function getDescrOffre()
    {
        return $this->descrOffre;
    }

    /**
     * Set prix
     *
     * @param float $prix
     *
     * @return Offres
     */
    public function setPrix($prix)
    {
        $this->prix = $prix;

        return $this;
    }

    /**
     * Get prix
     *
     * @return float
     */
    public function getPrix()
    {
        return $this->prix;
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
}

