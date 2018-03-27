<?php

namespace UserBundle\Entity;

/**
 * HopitalService
 */
class HopitalService
{
    /**
     * @var integer
     */
    private $idHopital;

    /**
     * @var integer
     */
    private $idS;


    /**
     * Set idHopital
     *
     * @param integer $idHopital
     *
     * @return HopitalService
     */
    public function setIdHopital($idHopital)
    {
        $this->idHopital = $idHopital;

        return $this;
    }

    /**
     * Get idHopital
     *
     * @return integer
     */
    public function getIdHopital()
    {
        return $this->idHopital;
    }

    /**
     * Set idS
     *
     * @param integer $idS
     *
     * @return HopitalService
     */
    public function setIdS($idS)
    {
        $this->idS = $idS;

        return $this;
    }

    /**
     * Get idS
     *
     * @return integer
     */
    public function getIdS()
    {
        return $this->idS;
    }
}

