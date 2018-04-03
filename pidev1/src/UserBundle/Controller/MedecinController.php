<?php


namespace UserBundle\Controller;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class MedecinController extends Controller
{
    public function redirectAction()
    {
        $m=$this->getDoctrine()->getManager();
        $articles=$m->getRepository('UserBundle:Articles')->findAll();

        return $this->render('UserBundle:medecin:acceuil.html.twig',array('article'=>$articles));
    }


}