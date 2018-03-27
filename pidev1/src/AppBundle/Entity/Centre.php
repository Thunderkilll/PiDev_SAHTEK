<?php

namespace AppBundle\Entity;

/**
 * Centre
 */
class Centre
{
    /**
     * @var string
     */
    private $nomCentre;

    /**
     * @var string
     */
    private $adresseCentre;

    /**
     * @var integer
     */
    private $telephone;

    /**
     * @var \AppBundle\Entity\Reservation
     */
    private $idCentre;

    /**
     * @var \AppBundle\Entity\Produit
     */
    private $idProduit;

    /**
     * @var \AppBundle\Entity\Offres
     */
    private $nom;


    /**
     * Set nomCentre
     *
     * @param string $nomCentre
     *
     * @return Centre
     */
    public function setNomCentre($nomCentre)
    {
        $this->nomCentre = $nomCentre;

        return $this;
    }

    /**
     * Get nomCentre
     *
     * @return string
     */
    public function getNomCentre()
    {
        return $this->nomCentre;
    }

    /**
     * Set adresseCentre
     *
     * @param string $adresseCentre
     *
     * @return Centre
     */
    public function setAdresseCentre($adresseCentre)
    {
        $this->adresseCentre = $adresseCentre;

        return $this;
    }

    /**
     * Get adresseCentre
     *
     * @return string
     */
    public function getAdresseCentre()
    {
        return $this->adresseCentre;
    }

    /**
     * Set telephone
     *
     * @param integer $telephone
     *
     * @return Centre
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
     * Set idCentre
     *
     * @param \AppBundle\Entity\Reservation $idCentre
     *
     * @return Centre
     */
    public function setIdCentre(\AppBundle\Entity\Reservation $idCentre)
    {
        $this->idCentre = $idCentre;

        return $this;
    }

    /**
     * Get idCentre
     *
     * @return \AppBundle\Entity\Reservation
     */
    public function getIdCentre()
    {
        return $this->idCentre;
    }

    /**
     * Set idProduit
     *
     * @param \AppBundle\Entity\Produit $idProduit
     *
     * @return Centre
     */
    public function setIdProduit(\AppBundle\Entity\Produit $idProduit = null)
    {
        $this->idProduit = $idProduit;

        return $this;
    }

    /**
     * Get idProduit
     *
     * @return \AppBundle\Entity\Produit
     */
    public function getIdProduit()
    {
        return $this->idProduit;
    }

    /**
     * Set nom
     *
     * @param \AppBundle\Entity\Offres $nom
     *
     * @return Centre
     */
    public function setNom(\AppBundle\Entity\Offres $nom = null)
    {
        $this->nom = $nom;

        return $this;
    }

    /**
     * Get nom
     *
     * @return \AppBundle\Entity\Offres
     */
    public function getNom()
    {
        return $this->nom;
    }
}

