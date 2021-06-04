import style from './Offers.module.css'

export function Offers({data}){
    return(
    <article>
        <p>
        {`Offer: ${data.off}`}
        </p>
    </article>
);
}