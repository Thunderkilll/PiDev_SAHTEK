<?php
// src/UserBundle/Entity/User.php

namespace UserBundle\Entity;

use FOS\UserBundle\Model\User as BaseUser;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity
 * @ORM\Table(name="user")
 */
class User extends BaseUser
{
    /**
     * @ORM\Id
     * @ORM\Column(type="integer")
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    protected $id;
    /**
     * @ORM\Column (type="string" , length=255 )
     */
    protected $name;
    /**
     * @ORM\Column (type="string" , length=255 )
     */
    protected $family_name;
    /**
     * @ORM\Column(type="integer")
     */
    protected $cin;
    /**
     * @ORM\Column (type="string" , length=255 )
     */
    protected $address;


    public function __construct()
    {
        parent::__construct();
        $this->name = "";
        $this->family_name = "";
        $this->address = "";
        $this->cin = 00000000;

    }

    /**
     * Set name
     *
     * @param string $name
     *
     * @return User
     */
    public function setName($name)
    {
        $this->name = $name;

        return $this;
    }

    /**
     * Get name
     *
     * @return string
     */
    public function getName()
    {
        return $this->name;
    }
/**
     * Set family_name
     *
     * @param string $family_name
     *
     * @return User
     */
    public function setFamilyName($fm)
    {
        $this->family_name = $fm;

        return $this;
    }

    /**
     * Get family_name
     *
     * @return string
     */
    public function getFamilyName()
    {
        return $this->family_name;
    }
    /**
     * Set address
     *
     * @param string $address
     *
     * @return User
     */
    public function setAddress($ad)
    {
        $this->address = $ad;

        return $this;
    }

    /**
     * Get address
     *
     * @return string
     */
    public function getAddress()
    {
        return $this->address;
    }

    /**
     * Get cin
     *
     * @return integer
     */
    public function getCin()
    {
        return $this->cin;
    }
    /**
     * Set cin
     *
     * @param integer $cin
     *
     * @return User
     */
    public function setCin($cin)
    {
        $this->cin = $cin;

        return $this;
    }


}