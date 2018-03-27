<?php

namespace UserBundle\Entity;

/**
 * Maladies
 */
class Maladies
{
    /**
     * @var string
     */
    private $symptomes;

    /**
     * @var string
     */
    private $description;

    /**
     * @var string
     */
    private $usrrole;

    /**
     * @var string
     */
    private $nom;


    /**
     * Set symptomes
     *
     * @param string $symptomes
     *
     * @return Maladies
     */
    public function setSymptomes($symptomes)
    {
        $this->symptomes = $symptomes;

        return $this;
    }

    /**
     * Get symptomes
     *
     * @return string
     */
    public function getSymptomes()
    {
        return $this->symptomes;
    }

    /**
     * Set description
     *
     * @param string $description
     *
     * @return Maladies
     */
    public function setDescription($description)
    {
        $this->description = $description;

        return $this;
    }

    /**
     * Get description
     *
     * @return string
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * Set usrrole
     *
     * @param string $usrrole
     *
     * @return Maladies
     */
    public function setUsrrole($usrrole)
    {
        $this->usrrole = $usrrole;

        return $this;
    }

    /**
     * Get usrrole
     *
     * @return string
     */
    public function getUsrrole()
    {
        return $this->usrrole;
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

