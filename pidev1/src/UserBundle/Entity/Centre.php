<?php

namespace UserBundle\Entity;

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
     * @var \UserBundle\Entity\Reservation
     */
    private $idCentre;

    /**
     * @var \UserBundle\Entity\Produit
     */
    private $idProduit;

    /**
     * @var \UserBundle\Entity\Offres
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
     * @param \UserBundle\Entity\Reservation $idCentre
     *
     * @return Centre
     */
    public function setIdCentre(\UserBundle\Entity\Reservation $idCentre)
    {
        $this->idCentre = $idCentre;

        return $this;
    }

    /**
     * Get idCentre
     *
     * @return \UserBundle\Entity\Reservation
     */
    public function getIdCentre()
    {
        return $this->idCentre;
    }

    /**
     * Set idProduit
     *
     * @param \UserBundle\Entity\Produit $idProduit
     *
     * @return Centre
     */
    public function setIdProduit(\UserBundle\Entity\Produit $idProduit = null)
    {
        $this->idProduit = $idProduit;

        return $this;
    }

    /**
     * Get idProduit
     *
     * @return \UserBundle\Entity\Produit
     */
    public function getIdProduit()
    {
        return $this->idProduit;
    }

    /**
     * Set nom
     *
     * @param \UserBundle\Entity\Offres $nom
     *
     * @return Centre
     */
    public function setNom(\UserBundle\Entity\Offres $nom = null)
    {
        $this->nom = $nom;

        return $this;
    }

    /**
     * Get nom
     *
     * @return \UserBundle\Entity\Offres
     */
    public function getNom()
    {
        return $this->nom;
    }
}

