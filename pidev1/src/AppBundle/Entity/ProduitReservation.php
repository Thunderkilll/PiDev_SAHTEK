<?php

namespace AppBundle\Entity;

/**
 * ProduitReservation
 */
class ProduitReservation
{
    /**
     * @var integer
     */
    private $idProduit;

    /**
     * @var integer
     */
    private $idReservation;


    /**
     * Set idProduit
     *
     * @param integer $idProduit
     *
     * @return ProduitReservation
     */
    public function setIdProduit($idProduit)
    {
        $this->idProduit = $idProduit;

        return $this;
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

    /**
     * Set idReservation
     *
     * @param integer $idReservation
     *
     * @return ProduitReservation
     */
    public function setIdReservation($idReservation)
    {
        $this->idReservation = $idReservation;

        return $this;
    }

    /**
     * Get idReservation
     *
     * @return integer
     */
    public function getIdReservation()
    {
        return $this->idReservation;
    }
}

