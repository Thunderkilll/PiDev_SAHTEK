<?php



namespace UserBundle\Entity;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * Class Modele
 * @package UserBundle\Entity
 */

/**
 * 
 * @ORM\Entity
 * @ORM\Table(name="fiche")
 */

class FichePatient
{
    /**
     * @ORM\GeneratedValue
     * @ORM\Id
     * @ORM\Column (type="integer")
     */

    private $id_fiche ;

    /**
     * @ORM\Column (type="string" , length=255 )
     */

    private $nom_p;
    /**
     * @ORM\Column (type="string" , length=255 )
     */

    private $prenom_p;

    /**
     * @ORM\Column (type="text" )
     */
    private $maladie;

    /**
     * @ORM\Column (type="text" )
     */
    private $traitement;

    /**
     * @ORM\Column (type="text" )
     */
    private $diagnostique;

    /**
     *
     * @ORM\Column(type="date")
     */
    private $date;



    /**
     * @return mixed
     */
    public function getIdFiche()
    {
        return $this->id_fiche;
    }

    /**
     * @param mixed $id_fiche
     */
    public function setIdFiche($id_fiche)
    {
        $this->id_fiche = $id_fiche;
    }

    /**
     * @return mixed
     */
    public function getNomP()
    {
        return $this->nom_p;
    }

    /**
     * @param mixed $nom_p
     */
    public function setNomP($nom_p)
    {
        $this->nom_p = $nom_p;
    }

    /**
     * @return mixed
     */
    public function getPrenomP()
    {
        return $this->prenom_p;
    }

    /**
     * @param mixed $prenom_p
     */
    public function setPrenomP($prenom_p)
    {
        $this->prenom_p = $prenom_p;
    }

    /**
     * @return mixed
     */
    public function getMaladie()
    {
        return $this->maladie;
    }

    /**
     * @param mixed $maladie
     */
    public function setMaladie($maladie)
    {
        $this->maladie = $maladie;
    }

    /**
     * @return mixed
     */
    public function getTraitement()
    {
        return $this->traitement;
    }

    /**
     * @param mixed $traitement
     */
    public function setTraitement($traitement)
    {
        $this->traitement = $traitement;
    }

    /**
     * @return mixed
     */
    public function getDiagnostique()
    {
        return $this->diagnostique;
    }

    /**
     * @param mixed $diagnostique
     */
    public function setDiagnostique($diagnostique)
    {
        $this->diagnostique = $diagnostique;
    }

    /**
     * @return mixed
     */
    public function getDate()
    {
        return $this->date;
    }

    /**
     * @param mixed $date
     */
    public function setDate($date)
    {
        $this->date = $date;
    }








}