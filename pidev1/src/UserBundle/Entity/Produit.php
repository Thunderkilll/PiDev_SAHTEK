<?php

namespace UserBundle\Entity;

/**
 * Produit
 */
class Produit
{
    /**
     * @var string
     */
    private $reference;

    /**
     * @var string
     */
    private $nom;

    /**
     * @var float
     */
    private $prix;

    /**
     * @var string
     */
    private $descrProduit;

    /**
     * @var integer
     */
    private $idProduit;


    /**
     * Set reference
     *
     * @param string $reference
     *
     * @return Produit
     */
    public function setReference($reference)
    {
        $this->reference = $reference;

        return $this;
    }

    /**
     * Get reference
     *
     * @return string
     */
    public function getReference()
    {
        return $this->reference;
    }

    /**
     * Set nom
     *
     * @param string $nom
     *
     * @return Produit
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
     * Set prix
     *
     * @param float $prix
     *
     * @return Produit
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
     * Set descrProduit
     *
     * @param string $descrProduit
     *
     * @return Produit
     */
    public function setDescrProduit($descrProduit)
    {
        $this->descrProduit = $descrProduit;

        return $this;
    }

    /**
     * Get descrProduit
     *
     * @return string
     */
    public function getDescrProduit()
    {
        return $this->descrProduit;
    }

    /**
     * Get idProduit
     *
     * @return integer
     */
    public function getIdProduit()
    {
        return $this->idProduit;
    }
}

