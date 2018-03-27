<?php

namespace AppBundle\Entity;

/**
 * OffreReservation
 */
class OffreReservation
{
    /**
     * @var string
     */
    private $idOff;

    /**
     * @var integer
     */
    private $idRes;


    /**
     * Set idOff
     *
     * @param string $idOff
     *
     * @return OffreReservation
     */
    public function setIdOff($idOff)
    {
        $this->idOff = $idOff;

        return $this;
    }

    /**
     * Get idOff
     *
     * @return string
     */
    public function getIdOff()
    {
        return $this->idOff;
    }

    /**
     * Set idRes
     *
     * @param integer $idRes
     *
     * @return OffreReservation
     */
    public function setIdRes($idRes)
    {
        $this->idRes = $idRes;

        return $this;
    }

    /**
     * Get idRes
     *
     * @return integer
     */
    public function getIdRes()
    {
        return $this->idRes;
    }
}

